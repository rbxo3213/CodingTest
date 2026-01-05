/*
2 * n 타일링
타일을 다 채웠을 때, 마지막 타일의 경우는
    1. 2 * 1 타일 하나 (가로 1 칸 소모)
    2. 1 * 2 타일 두 개 (가로 2 칸 소모)
n이 짝수일 때
    1. 2 * 1 타일 하나 => 남은 타일 n - 1은 홀수 : 2와 1을 사용해서 홀수 n - 1 만들기
    2. 1 * 2 타일 두 개 => 남은 타일 n - 2는 짝수 : 2와 1을 사용해서 짝수 n - 2 만들기
n이 홀수일 때
    1. 2 * 1 타일 하나 => 남은 타일 n - 1은 짝수 : 2와 1을 사용해서 짝수 n - 1 만들기
    2. 1 * 2 타일 두 개 => 남은 타일 n - 2는 홀수 : 2와 1을 사용해서 홀수 n - 2 만들기
    
예를 들어 2 * 5의 경우
1. 5 - 1 : 4 를 2와 1로 만들기
    - 1 1 1 1
    - 1 1 2
    - 1 2 1
    - 2 1 1
    - 2 2
2. 5 - 2 : 3 을 2와 1로 만들기
    - 1 1 1
    - 1 2
    - 2 1
 - 2 를 1과 2로 만들기
     - 1 1
     - 2
 - 1을 1과 2로 만들기
     - 1
dp[i] = dp[i - 1] + dp[i - 2];
dp[n - 1] + dp[n - 2]; 하면 될 것 같다.

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
        if (n == 2) return 2;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        
        return (int)dp[n];
    }
}


