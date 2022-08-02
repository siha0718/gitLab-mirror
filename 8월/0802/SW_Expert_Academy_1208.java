import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Expert_Academy_1208 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[] wall = new int[100];
		
		int T = 10;
		
		int max = 0;
		int min = 101;
		int max_index = 0;
		int min_index = 0;

		for(int t=1;t<=T;t++) {
			
			int dump = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < wall.length; i++) {
				wall[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for (int d = 0; d <= dump; d++) {
				
				max = 0;
				min = 101;
				max_index = -1;
				min_index = -1;
				
				for (int i = 0; i < wall.length; i++) {
					if(wall[i] > max) {
						max = wall[i];
						max_index = i;
					}
					
					if (wall[i] < min){
						min = wall[i];
						min_index = i;
					}				
				}
				
				if(d == dump)break;
								
				
				wall[max_index] -= 1;
				wall[min_index] += 1;
				
				
			}				
			
			System.out.printf("#%d %d", t, wall[max_index] - wall[min_index]);	
			System.out.println();
		}	
		
	}//main
	
}
