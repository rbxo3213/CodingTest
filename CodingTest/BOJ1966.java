import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            Queue<int[]> queue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine()," ");
            
            for(int j = 0; j<n; j++){
                int[] arr = new int[2];
                arr[0]=j;
                arr[1]=Integer.parseInt(st.nextToken());
                
                queue.offer(arr);
            }
            
            int count = 0;
            A:
            while(true){
                int max = queue.peek()[1];
                for(int[] a : queue){
                    if(a[1]>max){
                        queue.offer(queue.poll());
                        continue A;
                    }
                }
                if(queue.poll()[0]==m){
                    count++;
                    break;
                }
                count++;
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}