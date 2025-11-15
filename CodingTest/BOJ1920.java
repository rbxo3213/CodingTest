/*
문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.

시간 제한 1초
*/

package CodingTest;

import java.util.*;
import java.io.*;

public class BOJ1920{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<m; i++){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                bw.write(1+"\n");
            } else bw.write(0+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}

/*
단순히 List와 for문으로 접근하면 시간복잡도 O(n^2)으로 시간초과가 발생함.
HashSet 은 HashMap 기반으로 contains 메소드를 실행하는데 시간복잡도가 O(1)으로 탐색속도가 매우 빠르다.
앞으로 비슷한 탐색문제(중복이 없는)에는 HashSet을 떠올려보자
*/
