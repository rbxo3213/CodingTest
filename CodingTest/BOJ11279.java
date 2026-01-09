import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            
            if (val == 0) {
                if (maxHeap.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(maxHeap.poll() + "\n");
                }
            } else {
                maxHeap.add(val);
            }
        }
        
        System.out.print(sb.toString());
    }
}
