package day0810;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BJ_16926_배열돌리기1 {

	static int N, M;
	static int R;
	static int[][] board;
					//우 하 좌 상 		
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		//배열 입력 
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//배열돌리기
		for(int tc=0;tc<R;tc++) {
			int line = Math.min(N, M) / 2;
			
			cycle(line, 0);
		
		}
		
		
		//배열 출력
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
//				sb.append(board[i][j] + " ");
				bw.write(board[i][j] + " ");
			}
//			sb.append("\n");
			bw.write("\n");
		}
		
		
//		System.out.println(sb);
		bw.flush();
		bw.close();
		
	}//main
	
	
	
	private static void cycle(int line, int i) {
		
		if(i == line)	return;
		
		int d = 0;
		int x = i;
		int y = i;
		int nx, ny;
		int tmp = board[i][i];
		
		while(d<4) {
			
			nx = x + dx[d];
			ny = y + dy[d];
			
			if(nx >= 0+i && nx < N-i && ny >= 0+i && ny < M-i) {
				board[x][y] = board[nx][ny];
				x = nx;
				y = ny;
			}
			else {
				d+=1;
			}
			
		}
		
		board[i+1][i] = tmp;
		
		cycle(line, i+1);
		
	}//cycle
	
	
}
