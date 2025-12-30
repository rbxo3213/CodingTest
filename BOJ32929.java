import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = "UOS";
        String[] line = str.split("");
        int n = sc.nextInt();
        
        System.out.println(line[(n - 1) % 3]);
}

}