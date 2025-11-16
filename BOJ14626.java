package CodingTest;
import java.util.Scanner;

public class BOJ14626 {
    public static void main(String[] args){
        // 13자리 String
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().trim().split("");

        String missing = null;
        int front = 0;
        for(int i = 0; i<line.length; i++){
            if(line[i].equals("*")){
                i++;
                continue;
            }
            front += Integer.parseInt(line[i]);
            i++;
        }
        int back = 0;
        for(int i = 1; i<line.length; i++){
            back += Integer.parseInt(line[i])*3;
            i++;
        }
        // * 빼고 더한 결과 %10을 10에서 빼면 되지 않나?
        System.out.println(front+"\n"+back+"\n"+(front+back)+"\n"+(front+back)%10);
    }

}
