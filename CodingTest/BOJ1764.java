import java.util.*;
import java.io.*;

public class BOJ1764{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Set<String> noD = new HashSet<>();
        Set<String> noB = new HashSet<>();
        List<String> noDB = new ArrayList<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int count = 0;
        boolean turn = true;
        for(int i = 0; i<n+m; i++){
            if(count==2){
                turn = !turn;
                count=0;
            }
            if(turn){
                String tmp = br.readLine();
                noD.add(tmp);
                if(noB.contains(tmp)){
                    noDB.add(tmp);
                }
            } else{
                String tmp = br.readLine();
                noB.add(tmp);
                if(noD.contains(tmp)){
                    noDB.add(tmp);
                }
            }
            count++;
        }
        sb.append(noDB.size()+"\n");
        Collections.sort(noDB);
        for(String s : noDB){
            sb.append(s+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}