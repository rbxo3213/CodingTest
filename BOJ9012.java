package CodingTest;
import java.io.*;
import java.util.*;

public class BOJ9012 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        A:
        for(int i=0; i<n; i++){
            Stack<String> stack = new Stack<>();

            String line = br.readLine();
            String[] strArr = line.trim().split("");
            for(String s : strArr){
                if(s.equals("(")){
                    stack.push("(");
                } else if(s.equals(")")&&(!stack.isEmpty())){
                    if(stack.peek().equals("(")){
                        stack.pop();
                    } else if (stack.peek().equals(")")){
                        bw.write("NO\n");
                        continue A;
                    }
                } else if (s.equals(")")&&stack.isEmpty()){
                    bw.write("NO\n");
                    continue A;
                }

            }
            if(!stack.isEmpty()){
                bw.write("NO\n");
                continue A;
            }
            bw.write("YES\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
Stack 활용해서 풀이

"("가 입력되면 스택에 (을 푸쉬

")"가 입력되면

stack이 비었다면 NO
stack의 top이 "("라면 "( )"이 짝지어졌으므로 스택을 pop
stack이 top이 ")"라면 NO
한 문장의 for문이 전부 돌아가면

stack이 비었는지 검사하기
비었다면 : 균형있게 짝지어짐
비지 않았다면 : "("가 ")"보다 더 입력됨.
근데 괄호가 한 종류이면 stack에 굳이 "("를 push하지 않고 그냥 1 푸쉬하고 pop해도 될 것 같다.
 */