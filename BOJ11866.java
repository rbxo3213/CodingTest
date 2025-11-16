package CodingTest;

// QUEUE쓰면 될거같음
import java.util.*;

public class BOJ11866{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());
        sc.nextLine();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++){
            queue.offer(Integer.valueOf(i));
        }
        System.out.println(solution(queue).toString().replace("[","<").replace("]",">"));
    }
    public static List<Integer> solution(Queue<Integer> queue){
        List<Integer> list = new ArrayList<>();
        int turn = 1;
        while(!queue.isEmpty()){
            if(turn==3){
                list.add(queue.poll());
                turn = 1;
            } else {
                queue.offer(queue.poll());
                turn ++;
            }
        }
        return list;
    }
}

/*
시행착오
1. 우선 System.out.println(list)의 형식은 [3, 6, 2, 7,...] 인데, 문제에서 요구하는 출력방식은 <3, 6, 2, 7...> 였다.
2. n이랑 k 입력받아 놓고 turn==3 이렇게 하드코딩 해버려서 계속 k가 3인 결과만 나왔다. IDE안썼으면 못 찾았을 거 같다..
제발 하드코딩 하지 말자
하드코딩 하는 경우 ==> public static final int VALUE = 값 하고 상수 선언했을 때만 !!!!!!!!

틀렸던 코드를 남기는게 더 의미있을 것 같아서 이대로 커밋
 */