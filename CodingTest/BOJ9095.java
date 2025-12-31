import java.util.*;

public class Main{
    public static void main(String[] g) {
        Scanner sc = new Scanner(System.in);
        
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(sc.nextLine());
            
            sb.append(solution(num) + "\n");
        }
        System.out.print(sb.toString());
    }
    
    private static int solution(int num) {
        if (num == 1) return 1;
        if (num == 2) return 2;
        int[] dp = new int[num + 1];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for (int i = 4; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        return dp[num];
    }
}
