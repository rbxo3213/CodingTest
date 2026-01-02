import java.io.*;
import java.util.*;

public class Main{
    private static int N;
    private static int[] arr;
    private static int[] pick = new int[6];
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true) {
            String line = br.readLine();
            if (line == null) break;
            
            st = new StringTokenizer(line, " ");
            N = Integer.parseInt(st.nextToken());
            
            if (N == 0) break;
            arr = new int[N];
            
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            dfs(0, 0);
            sb.append("\n");
            
        }
        System.out.print(sb.toString());
    }
    private static void dfs(int depth, int start) {
        if (depth == pick.length) {
            for (int i = 0; i < pick.length; i++) {
                sb.append(pick[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            pick[depth] = arr[i];
            dfs(depth + 1, i + 1);
            
        }
    }
}
