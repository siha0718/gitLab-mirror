import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_1697_숨바꼭질 {
	
	static int N, K;
	static int MAX = 100001;
	static int min = Integer.MAX_VALUE;
	static int[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		visited = new int[MAX];
		
		bfs(N, 0);

	}

	private static void bfs(int now, int time) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(now);
		visited[now] = 1;
		
		while(!queue.isEmpty()) {
			
			int x = queue.poll();
			
			if(x == K)	break;
			
			if(x + 1 < MAX && visited[x+1] == 0) {
				queue.add(x+1);
				visited[x+1] = visited[x] + 1;
			}
			
			if(x -1 >= 0 && visited[x-1] == 0) {
				queue.add(x-1);
				visited[x-1] = visited[x] + 1;
			}
			
			if(x * 2 < MAX && visited[x*2] == 0) {
				queue.add(x*2);
				visited[x*2] = visited[x] + 1;
			}
			
		}
		
		System.out.println(visited[K] -1 );
	}

	
	
	
}
