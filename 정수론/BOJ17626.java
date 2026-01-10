// 라그랑주 승수 판별 문제
// 레장드르 3제곱수 정리
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        
        if (isSquare(n)) {
            System.out.println(1);
            return;
        }
        if (isSumOfSquares(n)) {
            System.out.println(2);
            return;
        }
        
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            System.out.println(4);
        } else System.out.println(3);
    }
    private static boolean isSquare (int n) {
        int root = (int)Math.sqrt(n);
        return n == root * root;
    }
    private static boolean isSumOfSquares(int n) {
        int limit = (int)Math.sqrt(n);
        for (int i = 1; i <= limit; i++) {
            int b2 = n - i * i;
            if (isSquare(b2)) return true;
        }
        return false;
    }
}
