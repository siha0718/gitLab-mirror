import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1987_알파벳 {
	
	static int R, C, cnt;
	static char[][] board;
	static boolean[] alphabet = new boolean[26];
	static int[] dx = { -1, 0, 1,  0};	//상 우 하 좌
	static int[] dy = {  0, 1, 0, -1};
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				board[i] = str.toCharArray();
			}
		}
		
		dfs(0, 0, 1);
		System.out.println(max);
		
		
		
		
	}//main
	
	

	private static void dfs(int x, int y, int cnt) {
		
		if(max == 26)	return;
		
		alphabet[board[x][y] - 65] = true;
		
		int nx, ny;
		
		for(int i=0;i<4;i++) {
			
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx >= 0 && nx < R && ny >= 0 && ny < C && !alphabet[board[nx][ny] - 65]) {
				alphabet[board[nx][ny] - 65] = true;
				dfs(nx, ny, cnt+1);
				alphabet[board[nx][ny] - 65] = false;
				
			}
			
			
		}
		
		max = Math.max(max, cnt);
		return;
		
		
		
		
	}//end dfs
	
}//end class
