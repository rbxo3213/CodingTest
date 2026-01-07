import java.io.*;
import java.util.*;

public class Main{
    private static int n, m;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int extent = 0;
        int drawing = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    int tmp = bfs(new Node(i, j));
                    if (extent < tmp) {
                        extent = tmp;
                    }
                    drawing += 1;
                }
            }
        }
        
        System.out.println(drawing + "\n" + extent);
    }
    private static int bfs(Node start) {
        Deque<Node> queue = new ArrayDeque<>();
        int extent = 0;
        
        queue.offer(start);
        visited[start.row][start.col] = true;
        extent += 1;
        
        while(!queue.isEmpty()) {
            Node nowNode = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                Node nextNode = new Node(nowNode.row + dr[i], nowNode.col + dc[i]);
                
                if (nextNode.row < 0 || nextNode.row >= n || nextNode.col < 0 || nextNode.col >= m) {
                    continue;
                }
                if (graph[nextNode.row][nextNode.col] == 0 || visited[nextNode.row][nextNode.col]) {
                    continue;
                }
                
                queue.offer(nextNode);
                visited[nextNode.row][nextNode.col] = true;
                extent += 1;
            }
        }
        return extent;
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
