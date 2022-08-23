import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_7576_토마토 {
	
	static int M, N;
	static int[][] board;
	static boolean[][] visited;
	static int[][] res;	
	static int[] dx = {-1, 1, 0, 0};	//상, 하, 좌, 우
	static int[] dy = {0, 0, -1, 1};
	static Queue<Tomato> tomato;
	static int minTime = Integer.MIN_VALUE;
	
	static class Tomato{
		
		int x;
		int y;
		
		public Tomato(int x, int y) {

			this.x = x;
			this.y = y;
		}	
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new LinkedList<>();
		
		board = new int[N][M];
		visited = new boolean[N][M];
		res = new int[N][M];
		int startTomato = 0;
		int all = N*M;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) {
					tomato.add(new Tomato(i, j));
					visited[i][j] = true;
					all -= 1;
				}
				if(board[i][j] == -1) {
					res[i][j] = -1;
					all -= 1;
				}
			}
		}
		
		startTomato = tomato.size();
		
		if(all == 0) {
			System.out.println(0);
		}	
		
		else {
			
			bfs();
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(res[i][j] == 0) {
						startTomato -= 1;
						if(startTomato < 0) {
							System.out.println(-1);
							System.exit(0);
						}
						
					}
					else {
						minTime = Math.max(res[i][j], minTime);
					}
				}
			}
			
			System.out.println(minTime);
		}
		
		
	}//main

	private static void bfs() {
		
		
		while(!tomato.isEmpty()) {
			
			Tomato nowT = tomato.poll();
			
			int nx, ny;
			
			for(int i=0;i<4;i++) {
				
				nx = nowT.x + dx[i];
				ny = nowT.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && board[nx][ny] != -1) {
					
					if(board[nx][ny] == 0) {
						res[nx][ny] = res[nowT.x][nowT.y] + 1;
						board[nx][ny] = 1;
						visited[nx][ny] = true;
						tomato.add(new Tomato(nx, ny));
					}
					
				}
				
				
			}
			
			
		}//end while
		
		
		
	}// end bfs
	
	
}//end class

