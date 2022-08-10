import java.io.*;
import java.util.*;

public class Main_BJ_17406_배열돌리기4 {
	
	static int N, M, K;
	static int[][] board;
	static int answer = Integer.MAX_VALUE;
	static int[][] cycle;
	static int[] dx = {1, 0, -1, 0}; // 하, 우, 상, 좌
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cycle = new int[K][3];
		
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			cycle[i][0] = Integer.parseInt(st.nextToken()) - 1;
			cycle[i][1] = Integer.parseInt(st.nextToken()) - 1;
			cycle[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		perm(0, new int[K], new boolean[K]);
		
		
		System.out.println(answer);
	}

	
	
	public static void rotate(int[] arr) {

		int[][] copy = new int[N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				copy[i][j] = board[i][j];
			}
		}
		
		for (int tc = 0; tc < K; tc++) {
			// 현재 뽑은 인덱스를 받아들인다.
			int r = cycle[arr[tc]][0];
			int c = cycle[arr[tc]][1];
			int s = cycle[arr[tc]][2];
			
	         // 회전할 배열의 좌표 범위
            int minX = r - s, minY = c - s;
            int maxX = r + s, maxY = c + s;

            // 가장자리부터 안쪽까지 s번 회전하면 된다.
            for (int t = 0; t < s; t++) {
                int temp = copy[minX][minY];

                int curR = minX, curC = minY;
                int d = 0;

                while (true) { // 배열 회전
                    int nx = curR + dx[d];
                    int ny = curC + dy[d];

                    // 회전 범위를 벗어나면 방향 변환
                    if (nx < minX || nx > maxX || ny < minY || ny > maxY) {
                        d = ++d % 4;

                        nx = curR + dx[d];
                        ny = curC + dy[d];
                    }

                    // 최초 지점으로 복귀시 종료
                    if (nx == minX && ny == minY) {
                        break;
                    }

                    // 다음 번 칸의 값을 가져와 저장
                    copy[curR][curC] = copy[nx][ny];

                    // 다음 번 칸으로 이동
                    curR = nx;
                    curC = ny;
                }

                copy[minX][minY + 1] = temp;

                // 회전 범위 축소
                minX++; minY++;
                maxX--; maxY--;
            }
        }
		
		// 최소값 계산
		for(int i=0;i<N;++i) {
			int sum = 0;
			for(int j=0;j<M;++j) {
				sum += copy[i][j];
			}
			answer = Math.min(answer, sum);
		}
	}

	
	public static void perm(int cnt, int[] arr, boolean[]visited) {
		
		if(cnt == K) {
			rotate(arr);
			return;
		}
		
		for(int i=0;i<K;i++) {
			if(visited[i])	continue;
			visited[i] = true;
			arr[cnt] = i;
			perm(cnt+1, arr, visited);
			visited[i] = false;
		}
		
	}
	
	
}
