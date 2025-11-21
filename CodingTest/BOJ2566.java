import java.io.*;
import java.util.*;

public class BOJ2566{
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[9][];
        for(int i = 0; i<9; i++){
            arr[i] = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            
        }
        int max = arr[0][0];
        int maxCol = 0;
        int maxRow = 0;
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(arr[i][j]>max){
                    max=arr[i][j];
                    maxCol=j+1;
                    maxRow=i+1;
                }
            }
        }
        bw.write(max+"\n");
        bw.write(maxRow+" "+maxCol+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}