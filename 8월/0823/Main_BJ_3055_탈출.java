import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_3055_탈출 {
	
	static int R, C;
	static char[][] board;
	static boolean[][] svisited;
	static boolean[][] wvisited;
	static int[][] wRes;
	static int[][] sRes;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static Queue<S_Now> Squeue = new LinkedList<>();
	static Queue<WaterNow> Wqueue = new LinkedList<>();
	
	static class S_Now {
		
		int x;
		int y;
		
		public S_Now(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static class WaterNow {
		
		int x;
		int y;
		
		public WaterNow(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		svisited = new boolean[R][C];
		wvisited = new boolean[R][C];
		wRes = new int[R][C];
		sRes = new int[R][C];
		int sX = 0, sY = 0;
		int wX = 0, wY = 0;
		
		/*
		 * 빈곳 		: . 
		 * 물 찬 곳 	: *
		 * 돌 		: X
		 * 비버굴 		: D
		 * 고슴도치 	: S
		 * 
		 * 고슴도치 사방탐색
		 * 물도 사방탐색
		 * *와 S는 D 통과 불가
		 * S는 * 통과 불가
		 * *는 D 통과 불가
		 * 고슴도치는 물이 찰 '예정'인 곳으로 이동 불가 ???? 
		 * 
		 */
		
		
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				board[i][j] = str.charAt(j);
				if(board[i][j] == 'S') {
					Squeue.add(new S_Now(i, j));
					svisited[i][j] = true;
				}
				if(board[i][j] == '*') {
					Wqueue.add(new WaterNow(i, j));
					wvisited[i][j] = true;
				}
				
			}
		}
		
		
		
		bfs();
		System.out.println("KAKTUS");

	}

	
	
	
	
	
	private static void bfs() {
		
			
		while(true) {
			
			
			int nsx, nsy, nwx, nwy;
			int len = Wqueue.size();
			
			while(len>0) {
				
				WaterNow wNow = Wqueue.poll();
				wvisited[wNow.x][wNow.y] = true; 
				
				for(int i=0;i<4;i++) {		
					
					nwx = wNow.x + dx[i];
					nwy = wNow.y + dy[i];
					
					if(nwx >= 0 && nwx < R && nwy >= 0 && nwy < C && !wvisited[nwx][nwy]) {
						if(board[nwx][nwy] != 'X' && board[nwx][nwy] != 'D') {
							Wqueue.add(new WaterNow(nwx, nwy));
							wRes[nwx][nwy] = wRes[wNow.x][wNow.y] + 1; 
							wvisited[nwx][nwy] = true;
						}
						
					}
					
				}
				
				len--;
				
			}//end Wqueue while
			
			len = Squeue.size();
			while(len>0) {
				
				S_Now sNow = Squeue.poll();
				svisited[sNow.x][sNow.y] = true; 
				
				for(int i=0;i<4;i++) {
					
					nsx = sNow.x + dx[i];
					nsy = sNow.y + dy[i];
					
					if(nsx >= 0 && nsx < R && nsy >= 0 && nsy < C && !svisited[nsx][nsy] && board[nsx][nsy] != 'X') {
						if(wRes[nsx][nsy] == 0) {
							if(board[nsx][nsy] == 'D') {
								System.out.println(sRes[sNow.x][sNow.y] + 1);
								System.exit(0);
							}
							else {
								Squeue.add(new S_Now(nsx, nsy));
								sRes[nsx][nsy] = sRes[sNow.x][sNow.y] + 1; 
								svisited[nsx][nsy] = true;		
							}
							
						}
					}
					
				}
				len--;
				
			}//end Squeue while
			
			if(Squeue.isEmpty() && Wqueue.isEmpty())	break;
			
		}//end while
		
		
		
		
	}//end bfs
	
	
	
	
}//end class