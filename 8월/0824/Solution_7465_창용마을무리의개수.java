import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수 {
	
	static int T, N, M, cnt;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T=Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			input = new ArrayList<ArrayList<Integer>>();
			
			for (int i = 0; i < N+1; i++) {
				input.add(i, new ArrayList<Integer>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int len= st.countTokens();
				int x=Integer.parseInt(st.nextToken());
				
				if(len==2) {
					int y=Integer.parseInt(st.nextToken());
					input.get(x).add(y);
					input.get(y).add(x);
					continue;
				}
				
				input.get(x).add(x);
			}
			
			visited = new boolean[N+1];
			cnt = 0;
			
			for (int i = 1; i < N+1; i++) {
				if(dfs(i)) cnt++;
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	private static boolean dfs(int i) {
		
		if(!visited[i]) {
			
			visited[i]=true;
			
			for (int j = 0; j < input.get(i).size(); j++) {
				
				if(!visited[input.get(i).get(j)]) {
					dfs(input.get(i).get(j));
				}
				
			}
			
			return true;
		}

		return false;
	}
}
