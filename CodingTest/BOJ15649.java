// 백트래킹 - N과 M 시리즈 (1)

import java.util.*;

public class Main{
    private static int[] arr;
    private static int N;
    private static int M;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visited = new boolean[N + 1];
        dfs(0);
        System.out.print(sb.toString());
    }
    public static void dfs(int depth) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i + " ");                
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}
