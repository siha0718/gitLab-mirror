package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11660_구간합구하기5 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		int[][] board = new int[N+1][N+1];
		int[][] nsum = new int[N+1][N+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<N+1;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//가로 누적합 
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				nsum[i][j] = nsum[i][j-1] + board[i][j];
			}
		}
		
		
		for(int tc=0;tc<M;tc++) {
			StringBuilder sb = new StringBuilder();
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i=x1;i<=x2;i++) {				
					sum += nsum[i][y2] - nsum[i][y1-1];
			}
			
//			sb.append(sum);
//			System.err.println(sb.toString());
			System.out.println(sum);
			
		}
		
		
		
		
		
		
		
		
	}
	
}
