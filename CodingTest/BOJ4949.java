package CodingTest;

// 스택 쓰면 괜찮을지도?
/*
( 나 [ 가 들어오면 스택에 쌓으면서, ]나 )가 탐색되면 빼는 형식 근데 STACK의 TOP 조회하는 법을 모른다.
*/

import java.io.*;
import java.util.*;

public class BOJ4949 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack;
        A:
        while(true){
            String str = br.readLine();
            if(str.equals(".")) break A;
            String[] strArr = str.split("");
            stack = new Stack<>();
            for(String s : strArr){
                if (s.equals("(")){
                    stack.push("(");
                } else if (s.equals("[")){
                    stack.push("[");
                } else if (s.equals("]")&&(!stack.isEmpty())){
                    if(stack.peek().equals("[")){
                        stack.pop();
                    } else {
                        //bw.write(str+"\n");
                        bw.write("no\n");
                        continue A;
                    }
                } else if (s.equals(")")&&(!stack.isEmpty())){
                    if(stack.peek().equals("(")){
                        stack.pop();
                    } else{
                        //bw.write(str+"\n");
                        bw.write("no\n");
                        continue A;
                    }
                } else if ((s.equals("]")||s.equals(")"))&&stack.isEmpty()){
                    //bw.write(str+"\n");
                    bw.write("no\n");
                    continue A;
                }
            }
            if(!stack.isEmpty()){
                bw.write("no\n");
                continue A;
            }
            //bw.write(str+"\n");
            bw.write("yes\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
스택 써서 푸는게 맞는 것 같다 속도도 빠르고
조건문에서 (((((( 하고 (이나 [만 입력되었을 때 걸리지 않아 yes가 나오는 오류가 있었다.

for문이 끝난 뒤 stack이 비어있어야 균형을 맞춘 것이므로,
for문이 끝난 후
if(!stack.isEmpty()){
   no를 출력하고 다음문장으로 넘어간다
}
를 추가하여 정답
 */