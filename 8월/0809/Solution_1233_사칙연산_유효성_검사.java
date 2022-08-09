package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산_유효성_검사 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
			
		for(int tc=0;tc<10;tc++) {
			int ans = 1;
			
			int N = Integer.parseInt(br.readLine());
			String[] tree = new String[N+1];
			
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				tree[Integer.parseInt(st.nextToken())] = st.nextToken();
			}
			
			int half_Node = N/2;
			for(int i=1;i<N+1;i++) {
				//두번째 입력받은 문자가 숫자일때
				if(tree[i].charAt(0) >= '0' && tree[i].charAt(0) <= '9') {
					// 리프노드보다 작으면
					if(i <= half_Node) {	
						ans = 0;
						break;
					}
					
				}
				//두번째 입력받은 문자가 연산자일때
				else {
					//연산자인데 리프노드이면 연산 불가
					if( i > half_Node) {
						ans = 0;
						break;
					}
				}
				
			}
			
			System.out.printf("#%d %d\n", (tc+1), ans);
		}
		
		
		
	}
	
	
}
