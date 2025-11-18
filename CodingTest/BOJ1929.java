import java.util.*;
import java.io.*;

public class BOJ1929{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        //List<boolean>list = new LinkedList<>();
        boolean[] list = new boolean[b+1];
        list[0]=true;
        list[1]=true;
        for(long i = 2; i<=b; i++){
            if(list[(int)i]) continue;
            for(long j = i; j*i<=b; j++){
                if(i*j<=b) list[(int)(i*j)]=true;
            }
        }
        for(int i = a; i<=b; i++){
            if(!list[i]) bw.write(i+"\n");
            
        }
        bw.flush();
        bw.close();
        br.close();
    }
}