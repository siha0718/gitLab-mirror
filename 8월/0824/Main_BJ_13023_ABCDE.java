import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_13023_ABCDE  {
	
	static int N, M;
	static List<Integer>[] input;
	static boolean[] visited;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new List[N];
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			input[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			input[a].add(b);
			input[b].add(a);
		}
		
		for(int i=0;i<N;i++) {
			if(!flag) {
				dfs(i, 0);
			}
		}
		
		if(flag)	System.out.println(1);
		else		System.out.println(0);
	}

	private static void dfs(int start, int cnt) {
		
		if(cnt == 4) {
			flag = true;
			return;
		}
	
//		visited[start] = true;
		
		for(int i=0;i<input[start].size();i++) {
			if(!visited[input[start].get(i)]) {
				visited[start] = true;
				dfs(input[start].get(i), cnt+1);	
				visited[start] = false;		
			}				
		}
	}

	
}
