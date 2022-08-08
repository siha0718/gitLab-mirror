package day0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Solution_9229_한빈이와_Spot_Mart {

	
	static int T;
	static int N, M;
	static int[] snack;
	static int res;
	static int MAX;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			
			MAX = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					res = snack[i] + snack[j];
					if(res <= M && res > MAX) MAX = res;
				}
			}
			
			if(MAX == 0) System.out.printf("#%d %d\n", (tc+1), -1);
			else	System.out.printf("#%d %d\n", (tc+1), MAX);
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
	}
}
