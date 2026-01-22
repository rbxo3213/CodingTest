import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static char[][] graph;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] values = br.readLine().split("\\s+");

        n = Integer.parseInt(values[0]);
        m = Integer.parseInt(values[1]);

        graph = new char[n][m];
        visited = new boolean[n][m];
        int[] start = new int[2];

        for (int i = 0; i < n; i++) {
            char[] lines = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                graph[i][j] = lines[j];
                if (graph[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        int result = bfs(start);
        System.out.println(result > 0 ? result : "TT");
    }
    private static int bfs(int[] start) {
        Deque<int[]> queue = new ArrayDeque<>();
        int count = 0;

        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = now[0] + dr[i];
                int nextC = now[1] + dc[i];

                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) {
                    continue;
                }
                if (graph[nextR][nextC] == 'X' || visited[nextR][nextC]) {
                    continue;
                }
                if (graph[nextR][nextC] == 'P') {
                    count++;
                }
                queue.offer(new int[] {nextR, nextC});
                visited[nextR][nextC] = true;
            }
        }

        return count;
    }
}
