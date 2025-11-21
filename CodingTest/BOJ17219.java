import java.io.*;
import java.util.*;

public class BOJ17219{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<String, String> map = new HashMap<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            String address = st.nextToken();
            String pw = st.nextToken();
            map.put(address, pw);
        }
        for(int i = 0; i<m; i++){
            String address = st.nextToken();
            sb.append(map.get(address)+"\n");
            
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}