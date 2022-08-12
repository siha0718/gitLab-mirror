import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws Exception {		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		int[][] board = new int[1001][1001];
		int[] paper = new int[N+1];				//색종이 개수 체크하는 배열
		int paperCheck = 1;
		
		for(int tc=0;tc<N;tc++) {
			
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int height =  Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			
			for(int i=r;i<r+height;i++) {
				for(int j=c;j<c+width;j++) {
					if(board[i][j] != 0) {
						paper[board[i][j]] -= 1;
						paper[paperCheck] += 1;
						board[i][j] = paperCheck;
					}
					else {
						board[i][j] = paperCheck;
						paper[paperCheck] += 1;
					}	
					
				}
			}
			
			paperCheck++;
			
		}
		
		
		for(int i=1;i<N+1;i++) {
			System.out.println(paper[i]);
		}
		
		
		
		
	}
	
}
