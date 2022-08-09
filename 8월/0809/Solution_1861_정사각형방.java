package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {	
					 //상, 하, 좌, 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = { 0, 0, -1, 1};	
	static int[][] check;
	static int N;
	static int[][] board;
	static int cnt;
	static int[] max;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			check = new int[N][N];
			max = new int[3];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					dfs(i, j);
					check[i][j] = cnt;
					if(max[0] < cnt){
						max[0] = cnt;
						max[1] = board[i][j];
					}
					else if(max[0] == cnt) {
						if (max[1] > board[i][j])	max[1] = board[i][j];
						
					}
					
					cnt = 0;
				}
			}
			
			System.out.printf("#%d %d %d\n", tc, max[1], max[0]+1);
			
		}//TC
		
		
	}//main
	
	
	
	public static void dfs(int x, int y) {
				
		int nx = 0;
		int ny = 0;
		
		for(int i=0;i<4;i++) {
				
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == (board[x][y] + 1)) {
				cnt += 1;
				dfs(nx, ny);
				return;
			}
			
		}		
		
		return;
	}
	
	
}//end class
