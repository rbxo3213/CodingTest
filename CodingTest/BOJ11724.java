import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        // 간선 입력 루프
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            list[node1].add(node2);
            list[node2].add(node1);
        }

        // 연결 요소 개수 계산 루프
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(list, visited, i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void bfs(ArrayList<Integer>[] list, boolean[] visited, int start) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            for (int nextNode : list[nowNode]) {
                if (!visited[nextNode]) {
                    queue.offer(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}
