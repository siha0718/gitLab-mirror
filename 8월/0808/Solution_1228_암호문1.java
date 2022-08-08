package day0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = 10;
		int N;
		int comm_num;
		String comm;
		int x, y;
		
		for(int tc=0;tc<T;tc++) {
			
			LinkedList<String> code = new LinkedList<>();
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				code.add(st.nextToken());
			}		
			
			comm_num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<comm_num;i++) {
				comm = st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				for(int j=0;j<y;j++) {
					code.add(x++, st.nextToken());	
				}
				
			}
			
			Iterator<String> iter = code.iterator();
			
			System.out.println("#" + (tc+1) + " ");
			for(int i=0;i<10;i++) {
				String str = iter.next();
				System.out.print(str + " ");
			}
			System.out.println();
			
		}
		
		
		
		
	}//main
}//end class
