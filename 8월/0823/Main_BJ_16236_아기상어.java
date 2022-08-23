import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.chrono.MinguoDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16236_아기상어 {

	static int N, M, babyShark, time;
	static int bsX, bsY;
	static int[][] board;
	static int[] dx = {-1, 1, 0, 0};		//상하좌우
	static int[] dy = {0, 0, -1, 1};
	static List<Fish> fish;
	static int[][] res;
	static boolean[][] visited;
	static int minDistance;
	
	/*
	 * 
	 * 아기상어는 자기보다 작은 크기의 물고기만 먹을 수 있다.
     * 큰 물고기는 먹지도 못하고 지나가지도 못함
	 * 크기가 같은 물고기는 먹을 수 없지만 지나갈 수 있음 
	 * 
	*/
	

	static class Fish {
		
		int x;
		int y;
		
		public Fish(int x, int y) {
			this.x = x;
			this.y = y;
		}	
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		babyShark = 2;
		board = new int[N][N];		
		
		fish = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {				
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] != 0 && board[i][j] != 9) {
					M++;
					fish.add(new Fish(i, j));
				}	
				if(board[i][j] == 9) {
					bsX = i;
					bsY = j;
				}
			}
			
		}
		
		
		
		int size = 0;
		while(fish.size() != 0) {
			
			res = new int[N][N];
			visited = new boolean[N][N];
			minDistance = Integer.MAX_VALUE;
			
			bfs(bsX, bsY);		
			
			if(minDistance != Integer.MAX_VALUE) {
				for(int i=0;i<M;i++) {
					
					int fx = fish.get(i).x;
					int fy = fish.get(i).y;
					
					if(res[fx][fy] == minDistance && board[fx][fy] < babyShark) {
						
						size++;	
						board[bsX][bsY] = 0;
						board[fx][fy] = 9;
						
						bsX = fx;
						bsY = fy;
						
						if(size == babyShark) {
							babyShark += 1;
							size = 0;
						}
						
						time += minDistance;
						fish.remove(i);
						M--;
								
						break;
					}
					
			
					
				}
			}
			
			
			
			else 	break;
			
			
			
		
		}

		
		System.out.println(time);
		
		
		
	}//main

	
	private static void print(int[][] list) {
		
		for (int i = 0; i < list.length; i++) {
			System.out.println(Arrays.toString(list[i]));
		}
		
	}


	private static void bfs(int x, int y) {
		
		Queue<Fish> queue = new LinkedList<>();
		
		
		queue.add(new Fish(x, y));
		visited[x][y] = true;
		
		int nx, ny;
		
		while(!queue.isEmpty()) {
			
			Fish baby = queue.poll();		
			
			
			for(int i=0;i<4;i++) {
				
				nx = baby.x + dx[i];
				ny = baby.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					if(board[nx][ny] <= babyShark) {
						queue.add(new Fish(nx, ny));
						visited[nx][ny] = true;
						res[nx][ny] = res[baby.x][baby.y] + 1;
						
						if(board[nx][ny] != 0 && board[nx][ny] != 9 && board[nx][ny] < babyShark) {
							minDistance = Math.min(minDistance, res[nx][ny]);
						}
						
					}
					
				}
				
			}
				
		}
		
		
		
	}//end bfs

	
	
}//end class
