package CodingTest;

import java.util.*;

public class BOJ2164{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        //List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            queue.offer(i);
        }
        System.out.println(solution(queue));
    }
    public static int solution(Queue<Integer> queue){
        while(queue.size()>1){
            queue.poll();
            queue.offer(queue.poll());
        }
        return queue.poll();
    }
}