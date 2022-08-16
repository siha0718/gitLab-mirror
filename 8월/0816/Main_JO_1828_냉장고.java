import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_JO_1828_냉장고 {
	
	static int N, cnt;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int[][] c = new int[N][2];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			c[i][0] = Integer.parseInt(st.nextToken());
			c[i][1] = Integer.parseInt(st.nextToken());	
		}
		
		Arrays.sort(c, Comparator.comparingInt(o1 -> o1[1]));

		int start = 0;				
		cnt = 1;
		for(int i=1;i<N;i++) {
			if(c[start][1] < c[i][0]) {
				start = i;
				i--;
				cnt++;
			}
		}
		
		
		System.out.println(cnt);
	}
	
}
