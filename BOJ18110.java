package CodingTest;

import java.io.*;
import java.util.*;

public class BOJ18110{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new LinkedList<>();

        for(int i = 0; i<n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        System.out.println(list);
        int p = (int)Math.round(n*0.15);

        for(int i = 0; i<p; i++){
            list.remove(0);
            list.remove(list.size()-1);
        }
        System.out.println(list);
        int total = 0;
        for(int i : list){
            total += i;
        }
        int result = (int)Math.round((double)total/list.size());
        System.out.println(result);
    }
}

/*
시행착오
1. total/list.size()할 때 (double)강제 형변환 하지 않음
    + Math.round의 반환 타입은 long
2. 시간 초과
- 삭제가 잦은 solution이라 ArrayList -> LinkedList로 바꿔 봄.
통과

통과 못 하면 queue 써보려 했는데 맞는 생각이었을까?
 */