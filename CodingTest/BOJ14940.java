import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static int M;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[][] graph;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];
        Node start = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    start = new Node(i, j);
                    graph[i][j] = 0;
                }
            }
        }
        bfs(start);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i][j] != 0) {
                    sb.append(-1 + " ");
                } else {
                    sb.append(graph[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    private static void bfs(Node node) {
        Deque<Node> queue = new ArrayDeque<>();

        queue.offer(node);
        visited[node.row][node.col] = true;

        while(!queue.isEmpty()) {
            Node nowNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                Node nextNode = new Node(nowNode.row + dr[i], nowNode.col + dc[i]);
                if (nextNode.row < 0 || nextNode.row >= N || nextNode.col < 0 || nextNode.col >= M) {
                    continue;
                }
                if (visited[nextNode.row][nextNode.col] || graph[nextNode.row][nextNode.col] == 0) {
                    continue;
                }
                queue.offer(nextNode);
                visited[nextNode.row][nextNode.col] = true;
                graph[nextNode.row][nextNode.col] = graph[nowNode.row][nowNode.col] + 1;
            }
        }
    }
    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
