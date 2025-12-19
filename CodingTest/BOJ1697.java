import java.util.*;

public class Main {
	private static int[] dist = new int[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int dest = sc.nextInt();
		
		BFS(start, dest);
	}
	public static void BFS(int start, int dest) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		queue.offer(start);
		dist[start] = 1;
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			
			int[] nextNode = {nowNode - 1, nowNode + 1, nowNode * 2};
			
			for (int next : nextNode) {
				if (next < 0 || next > 100001 || dist[next] != 0) continue;
				
				queue.offer(next);
				dist[next] = dist[nowNode] + 1;
			}
			
			if (dist[dest] != 0) break;
		}
		System.out.println(dist[dest] - 1);
	}
}
