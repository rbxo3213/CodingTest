import java.util.*;
import java.io.*;

public class BOJ10811{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        for(int i = 0; i<n; i++){
            arr[i]=i+1;
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int start = a;
            int end = b;
            while(start<=end){
                int tmp = arr[start-1];
                arr[start-1]=arr[end-1];
                arr[end-1]=tmp;
                start++;
                end--;
            }
            
            
        }
        for(int i : arr){
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}