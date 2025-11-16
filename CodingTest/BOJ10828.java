package CodingTest;

import java.io.*;
import java.util.*;


public class BOJ10828{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            String cmd = st.nextToken();
            if("push".equals(cmd)){
                stack.push(Integer.parseInt(st.nextToken()));
            } else if("pop".equals(cmd)){
                if(!stack.isEmpty()){
                    bw.write(stack.pop()+"\n");
                } else bw.write(-1+"\n");
            } else if("size".equals(cmd)){
                bw.write(stack.size()+"\n");
            } else if("empty".equals(cmd)){
                if(stack.isEmpty()){
                    bw.write(1+"\n");
                } else bw.write(0+"\n");
            } else if("top".equals(cmd)){
                if(!stack.isEmpty()){
                    bw.write(stack.peek()+"\n");
                } else bw.write(-1+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}