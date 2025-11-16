package CodingTest;

import java.util.*;
import java.io.*;

public class BOJ1920{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<m; i++){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                bw.write(1+"\n");
            } else bw.write(0+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}