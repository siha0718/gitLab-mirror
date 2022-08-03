import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2001_D2_파리퇴치 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N, M;
		int[][] board;
		int res;
		int tmp;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {

			res = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i=0;i<N-M+1;i++) {
				for(int j=0;j<N-M+1;j++) {
					tmp = 0;
					for(int k=i;k<i+M;k++) {
						for (int l=j;l<j+M;l++) {
							tmp += board[k][l];
						}
					}
					if (tmp > res)	res = tmp;					
				}
			}
			
			System.out.println("#" + (tc+1) + " " + res);
			
			
		}

	}

}
