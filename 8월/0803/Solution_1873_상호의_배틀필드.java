package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1873_상호의_배틀필드 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		char[][] board;
		
		for(int tc=0;tc<T;tc++){
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			board = new char[H][W];
			int car_x = -1;
			int car_y = -1;
			
			for(int i=0;i<H;i++) {
				String str = br.readLine();
				
				for(int j=0;j<W;j++) {					
					board[i][j] = str.charAt(j);
					
					//전차 위치 저장 
					if(board[i][j] == '^' || board[i][j] == 'v' || board[i][j] == '<' || board[i][j] == '>') {
						car_x = i;
						car_y = j;
					}
				}
//				System.out.println(Arrays.toString(board[i]));
			}
			
			
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char[] comm = str.toCharArray();
			
			for (int i = 0; i < comm.length; i++) {
				
				switch(comm[i]) {
				case 'U': 	
					board[car_x][car_y] = '^';
					if( (car_x)-1 >= 0 && (car_y) >= 0 && (car_x)-1 < H && (car_y) < W) {
						//한칸위가 평지라면 
						if(board[car_x-1][car_y] == '.') {
							board[car_x][car_y] = '.';						
							board[car_x-1][car_y] = '^';
							car_x--;
						}
						
					}
					break;	
					
				case 'D':
					
					board[car_x][car_y] = 'v';
					if( (car_x)+1 >= 0 && (car_y) >= 0 && (car_x)+1 < H && (car_y) < W) {
						//한칸아래가 평지라면 
						if(board[car_x+1][car_y] == '.') {
							board[car_x][car_y] = '.';						
							board[car_x+1][car_y] = 'v';
							car_x++;
						}						
					}
					break;
					
				case 'L':
					board[car_x][car_y] = '<';
					if( (car_x) >= 0 && (car_y)-1 >= 0 && (car_x) < H && (car_y)-1 < W) {
						//왼쪽이 평지라면 
						if(board[car_x][car_y-1] == '.') {
							board[car_x][car_y] = '.';						
							board[car_x][car_y-1] = '<';
							car_y--;
						}
						
					}
					break;
					
				case 'R':
					board[car_x][car_y] = '>';
					if( (car_x) >= 0 && (car_y)+1 >= 0 && (car_x) < H && (car_y)+1 < W) {
						//오른쪽이 평지라면 
						if(board[car_x][car_y+1] == '.') {
							board[car_x][car_y] = '.';						
							board[car_x][car_y+1] = '>';
							car_y++;
						}
						
					}
					break;
					
				case 'S':	//폭탄
						// 	     상, 하, 좌, 우
					int[] dx = {-1, 1, 0, 0};
					int[] dy = {0, 0, -1, 1};
					int d = -1;
					int sx = car_x;
					int sy = car_y;
					
					
					if(board[car_x][car_y] == '^') d=0;
					else if(board[car_x][car_y] == 'v') d=1;
					else if(board[car_x][car_y] == '<') d=2;
					else if(board[car_x][car_y] == '>') d=3;
				
			
					while(true) {
						
						sx += dx[d];
						sy += dy[d];
						
						//맵안에서 벽돌이나 강철벽 만났을 경우
						if(sx >= 0 && sx < H && sy >= 0 && sy < W) {
							//벽돌
							if(board[sx][sy] == '*') {
								board[sx][sy] = '.';
								break;
							}
							else if(board[sx][sy] == '#') {
								break;
							}
						}
						else	break;	
						
					}//while
					
				} //switch

				
				
			}
			
			
			
			
			
			System.out.print("#" + (tc+1) + " ");
			for(int i=0;i<H;i++) {
				for (char c : board[i]) {
					System.out.print(c);
				}
				System.out.println();
			}
			
			
			
		}//전체 for문
		
		
		
	}//main
	
}//end class
