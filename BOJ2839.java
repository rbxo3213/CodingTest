package CodingTest;
import java.util.Scanner;

public class BOJ2839 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        System.out.println(solution(n));
    }
    public static int solution(int n){
        int count3 = 0;
        int count5 = 0;
        while(true){
            if(n<3*count3){
                return -1;
            }
            if((n-3*count3)%5==0){
                count5 = (n-3*count3)/5;
                break;
            }
            count3++;
        }
        return count5+count3;
    }
}
