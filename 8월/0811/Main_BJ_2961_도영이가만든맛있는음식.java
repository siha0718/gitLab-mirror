import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] ingre;
	static int min_res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		ingre = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			ingre[i][0] = Integer.parseInt(st.nextToken());
			ingre[i][1] = Integer.parseInt(st.nextToken());

		}
		
		
//		subset(ingre, 0, 1, 0, 0);
		subset(ingre, 0, 1, 0);
		System.out.println(min_res);
		
		
	}//main
	
	public static void subset(int[][] arr, int idx, int sour, int bitter) {
	
		if(idx == N) {			
			if(min_res > Math.abs(sour-bitter) && bitter != 0) {
				min_res = Math.min(min_res, Math.abs(sour-bitter));				
			}
			return;
		}
		
		
		subset(arr, idx+1, sour, bitter);
		subset(arr, idx+1, sour*arr[idx][0], bitter+arr[idx][1]);
		
	}
	
	
}//end class

