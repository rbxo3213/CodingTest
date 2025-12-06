import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        
        str = str.replace("c=", "1").replace("c-", "2").replace("dz=", "3").replace("d-", "4").replace("lj", "5").replace("nj","6").replace("s=","7").replace("z=","8");
        
        System.out.println(str.length());
    }
}
