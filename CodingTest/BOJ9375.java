import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String cloth = st.nextToken();
                String type = st.nextToken();
                if (map.containsKey(type)) {
                    map.put(type, map.get(type) + 1);
                } else {
                    map.put(type, 1);
                }
                
            }
            int mul = 1;
            for (int val : map.values()) {
                mul *= (val + 1);
            }
            sb.append(mul - 1);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
