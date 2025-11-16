package CodingTest;

/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

생각해봤는데 스택, 큐 문제 이런거 직접 구현해보는 문제인건가
나중에 배열만 가지고 직접 구현해보자.
*/
import java.io.*;
import java.util.*;

public class BOJ10845{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int tmp = 0;
        for(int i = 0; i<n; i++){
            st=new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            if("push".equals(cmd)){
                tmp = Integer.parseInt(st.nextToken());
                queue.offer(tmp);
            } else if("pop".equals(cmd)){
                if(!queue.isEmpty()){
                    bw.write(queue.poll()+"\n");
                } else {
                    bw.write(-1+"\n");
                }
            } else if("size".equals(cmd)){
                bw.write(queue.size()+"\n");
            } else if("empty".equals(cmd)){
                if(queue.isEmpty()){
                    bw.write(1+"\n");
                } else{
                    bw.write(0+"\n");
                }
            } else if("front".equals(cmd)){
                if(!queue.isEmpty()){
                    bw.write(queue.peek()+"\n");
                } else{
                    bw.write(-1+"\n");
                }
            } else if("back".equals(cmd)){
                if(!queue.isEmpty()){
                    bw.write(tmp+"\n");
                } else{
                    bw.write(-1+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}


// queue의 맨앞과 맨뒤를 헷갈려서 front와 back을 반대로 작성하는 시행착오를 겪음.
// queue의 맨앞(가장 먼저 입력된 것)
// queue의 맨뒤(가장 나중에 입력된 것)





