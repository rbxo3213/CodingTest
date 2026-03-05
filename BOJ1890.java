import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] board;
    private static long[][] memo;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        board = new int[n][n];
        memo = new long[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        System.out.println(dfs(0, 0));
    }
    
    private static long dfs(int row, int col) {
        if (row >= n || col >= n) {
            return 0;
        }
        if (row == n - 1 && col == n - 1) {
            return 1;
        }
        if (board[row][col] == 0) {
            return 0;
        }
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        
        long result = dfs(row + board[row][col], col) + dfs(row, col + board[row][col]);
        return memo[row][col] = result;
    }
}
