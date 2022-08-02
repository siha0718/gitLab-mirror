import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
				// 우, 하, 왼, 상
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for(int t=0;t<T;t++) {
			
			int N = Integer.parseInt(br.readLine());
			if(N == 1) {
				System.out.println("#1\n1");
				continue;
			}
			int[][] arr = new int[N][N];
			arr[0][0] = 1;			
			
			int d = 0;
			int i = 0;
			int j = 0;
			
			while(true) {
				
				
				
				if(i+dx[d]<N && i+dx[d]>=0 && j+dy[d] < N && j+dy[d] >= 0 && arr[i+dx[d]][j+dy[d]] == 0) {
										
					arr[i+dx[d]][j+dy[d]] = arr[i][j] + 1;
					i += dx[d];
					j += dy[d];
					
					
				}				
				//다음것이 0이 아니면? 
				else{
					d+=1;
					if(d==4)	d=0;
					if(arr[i+dx[d]][j+dy[d]] != 0)	break;
				}
				
				
			}
			
			
			System.out.println("#" + (t+1));
			for(int l=0;l<N;l++) {
				for(int k=0;k<N;k++) {
					System.out.print(arr[l][k] + " ");
				}
				System.out.println();
			}
			
		}//for
		
		
		
		
	}//main
}//end class
