import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_10026_적록색약 {

	static int N, area = 0;
	static char[][] board;	
	static boolean[][] visited;
	static int[][] res;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Now{
		
		int x, y;
	
		public Now(int x, int y) {

			this.x = x;
			this.y = y;
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		visited = new boolean[N][N];
		res = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			board[i] = str.toCharArray();
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					area += 1;
					bfs(i, j, board[i][j]);
				}
				
			}
		}
		
		sb.append(area + " ");
		
		
		visited = new boolean[N][N];
		res = new int[N][N];
		area = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					area += 1;
					if(board[i][j] == 'R' || board[i][j] == 'G') {
						colors(i, j, 'R', 'G');
					}
					else {
						bfs(i, j, board[i][j]);
					}
					
				}
				
			}
		}
		
//		for(int []a : res) {
//			System.out.println(Arrays.toString(a));
//		}
		
		sb.append(area);
		System.out.println(sb);
		
		
	}//main	

	private static void bfs(int x, int y, char start) {
		
		Queue<Now> queue = new LinkedList<>();
		
		queue.add(new Now(x, y));
		visited[x][y] = true;
		res[x][y] = area;
		
		while(!queue.isEmpty()) {
			
			Now now = queue.poll();
			
			int nx, ny;
			
			for(int i=0;i<4;i++) {
				
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					
					if(board[nx][ny] == start) {
						queue.add(new Now(nx, ny));
						visited[nx][ny] = true;
						res[nx][ny] = area;
					}			
					
				}				
			}
				
		}//end while		
	}//end bfs
	
	
	private static void colors(int x, int y, char start1, char start2) {
		
		Queue<Now> queue = new LinkedList<>();
		
		queue.add(new Now(x, y));
		visited[x][y] = true;
		res[x][y] = area;
		
		while(!queue.isEmpty()) {
			
			Now now = queue.poll();
			
			int nx, ny;
			
			for(int i=0;i<4;i++) {
				
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					
					if(board[nx][ny] == start1 || board[nx][ny] == start2) {
						queue.add(new Now(nx, ny));
						visited[nx][ny] = true;
						res[nx][ny] = area;
					}			
					
				}				
			}
				
		}//end while		
	}//end bfs
	
	
}//end class
