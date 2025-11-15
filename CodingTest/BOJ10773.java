package CodingTest;

import java.io.*;
import java.util.*;

public class BOJ10773{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<k; i++){
            int n = Integer.parseInt(br.readLine());
            if(n!=0){
                stack.push(n);
            } else stack.pop();
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        System.out.println(result);
    }

}

/*
LIFO 쓰라고 대놓고 주는 문제
stack 써서 어렵지 않게 성공
result += stack.pop(); 을 result + stack.pop(); 으로 써서 한 번 컴파일 에러
stack.pop()은 Integer타입인데 int 타입으로 자동형변환

stream써서 형변환 하는 거 연습해야 하는데..
 */