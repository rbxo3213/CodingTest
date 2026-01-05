/*
dp[1] = 1
1

dp[2] = 3
1 1
2
2

dp[3] = 5
1 1 1
1 2
2 1
1 2
2 1

dp[4] = 12
1 1 1 1
1 1 2
1 2 1
2 1 1
2 2
1 1 2
1 2 1
2 1 1
2 2
2 2
2 2
*/
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        System.out.println(solution(n));
    }
    private static int solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 3;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        return dp[n];
    }
}
