import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        
        int count = 0;
        int nextMilk = 1;
        
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            
            if ((tmp + 1) % 3 == nextMilk) {
                count++;
                nextMilk = (nextMilk + 1) % 3;
            }
        }
        
        System.out.println(count);
    }
}

// 개어려움
