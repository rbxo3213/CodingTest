import java.util.*;

public class Main{
    private static int[] arr;
    private static int n;
    private static int m;
    private static int[] picked;
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] used;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        picked = new int[m];
        used = new boolean[n];
        st = new StringTokenizer(sc.nextLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb.toString());
    }
    private static void dfs(int depth) {
        if (depth == m) {
            for (int i : picked) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        int minval = 0;
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            if (minval == arr[i]) continue;
            used[i] = true;
            picked[depth] = arr[i];
            minval = arr[i];
            dfs(depth + 1);

            used[i] = false;
        }
    }
}
