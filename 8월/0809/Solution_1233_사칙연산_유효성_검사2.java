package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산_유효성_검사2 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
			
		for(int tc=0;tc<10;tc++) {
			int ans = 1;
			
			int N = Integer.parseInt(br.readLine());
			
			
			for(int i=0;i<N;i++) {
				String[] tree = br.readLine().split(" ");
				
				if(tree.length>=3 && tree[1].charAt(0) >= '0' || tree.length == 2 && tree[1].charAt(0) <'0' ) {
					for(int j=i+1;j<N;j++) {
						br.readLine();
					}
					ans = 0;
					break;
				}
			}	
			
			System.out.printf("#%d %d\n", (tc+1), ans);
		}

	}
	
}
