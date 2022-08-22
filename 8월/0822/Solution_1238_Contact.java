import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution {
	
	static int len, start;
	static int[] visited;
	static List<Integer>[] list;
	static int max;
	static int res;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int tc=1;tc<=10;tc++) {
			
			max = Integer.MIN_VALUE;
			res = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			visited = new int[101];
			list = new ArrayList[101];
			
			for(int i=1;i<=100;i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			st = new StringTokenizer(br.readLine());			
			for(int i=0;i<len/2;i++) {
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
			
				list[from].add(to);
				
			}
			
			
			bfs(start);
			visited[start] += 1;
			
			System.out.println("#" + tc + " " + res);
			
		}
		
	}

	private static void bfs(int now) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(now);		
		
		while(!queue.isEmpty()) {
			
			int tmp = queue.poll();
			
			for(int i=0;i<list[tmp].size();i++) {				
				
				if(visited[list[tmp].get(i)] == 0) {
					visited[list[tmp].get(i)] = visited[tmp] + 1;
					queue.offer(list[tmp].get(i));				
					
				}
				
			}
			
			max = visited[tmp];
			
		}
		
		for (int i = 1; i < 101; ++i) {
			if (max != visited[i]) {
				continue;
			}
			
			res = (res < i) ? i : res;
		}
		
	}
	
}
