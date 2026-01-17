import java.util.*;
import java.io.*;

public class Main {
    private static final int MAX = 10000;
    private static int s, e;
    private static int[] graph;
    private static int[] parent;
    private static char[] cmdArr;
    private static char[] cmd = {'D', 'S', 'L', 'R'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph = new int[MAX + 1];
            parent = new int[MAX + 1];
            cmdArr = new char[MAX + 1];
            Arrays.fill(graph, -1);
            parent[s] = -1;

            bfs();
            sb.append(solution() + "\n");
        }
        System.out.print(sb.toString());
    }
    private static String solution() {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        int cur = e;
        while (cur != -1) {
            stack.push(cmdArr[cur]);
            cur = parent[cur];
        }
        stack.pop();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    private static void bfs() {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(s);
        graph[s] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int next = 0;
            for (char c : cmd) {
                if (c == 'D') {
                    next = (now * 2) % 10000;
                } else if (c == 'S') {
                    next = now != 0 ? now - 1 : 9999;
                } else if (c == 'L') {
                    //next = rotate(now, -1);
                    next = L(now);
                } else if (c == 'R') {
                    //next = rotate(now, 1);
                    next = R(now);
                }

                if (next < 0 || next > MAX) continue;
                if (graph[next] != -1) continue;
                if (next == e) {
                    graph[next] = graph[now] + 1;
                    parent[next] = now;
                    cmdArr[next] = c;
                    return;
                }
                queue.offer(next);
                graph[next] = graph[now] + 1;
                parent[next] = now;
                cmdArr[next] = c;
            }


        }
    }
    private static int L(int num) {
        return (num % 1000) * 10 + num / 1000;
    }
    private static int R(int num) {
        return (num / 10) + (num % 10) * 1000;
    }
    private static int rotate(int num, int dir) {
        StringBuilder sb = new StringBuilder();
        String str = num + "";

        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        Collections.rotate(list, dir);
        for (char c : list) {
            sb.append(c);
        }

        return Integer.parseInt(sb.toString());
    }
}
