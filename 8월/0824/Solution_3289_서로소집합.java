import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	
	static int T, N, M;
	static int[] input;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			sb.append("#" + tc + " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			input = new int[N+1];
			for(int i=1;i<=N;i++) {
				input[i] = i;
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int comm = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch(comm) {
				case 0:
					union(a, b);
					break;
					
				case 1:
					
					int aRoot = find(input, a);
					int bRoot = find(input, b);
					
					if(aRoot == bRoot) {
						sb.append(1);
						break;	
					}
					else {
						sb.append(0);
						break;
					}
				}
				
			}
			
			sb.append("\n");
			
		}//end tc
		
		System.out.println(sb);
		
	}//main
	
	private static void union(int a, int b) {
		
		int aRoot = find(input, a);
		int bRoot = find(input, b);
		
		if(aRoot < bRoot)	input[bRoot] = aRoot;
		else				input[aRoot] = bRoot;
	}
	
//	private static boolean union2(int a, int b) {
//		
//		int aRoot = find(input, a);
//		int bRoot = find(input, b);
//		
//		if(aRoot == bRoot)	return true;
//		
//		return false;
//	}
//	

	private static int find(int[] input, int a) {
		if(input[a] != a) {
			return find(input, input[a]);
		}
		return input[a];
	}
	
}
