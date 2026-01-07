import java.util.*;

public class Main{
    private static int n, m;
    private static int[] arr;
    private static int[] picked;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        picked = new int[m];
        
        st = new StringTokenizer(sc.nextLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.print(sb.toString());
    }
    private static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i : picked) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i < n; i++) {
            picked[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}
