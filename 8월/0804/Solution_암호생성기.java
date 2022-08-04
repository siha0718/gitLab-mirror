package day0804;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_암호생성기 {
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();		
		StringTokenizer st = null;
		
		
		int T = 10;
		int N;
		int tmp = 0;
		int minus = 1;
		
		for (int tc = 0; tc < T; tc++) {			
			
			N = Integer.parseInt(br.readLine());
			queue.clear();
			st = new StringTokenizer(br.readLine());	
			for(int i=0;i<8;i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			
			all:while(true) {
				
				for(minus=1;minus<=5;minus++) {
					if(!queue.isEmpty()) {
						
						tmp = queue.poll();
						
						if(tmp-minus <= 0) {
							tmp = 0;
							queue.offer(tmp);				
							break all;
						}
						else {
							tmp -= minus;
							queue.offer(tmp);
						}
						
					} 
				}
				
			}
				

			Iterator iter = queue.iterator();
			System.out.print("#" + (tc+1) + " ");				
			while(iter.hasNext()) {
				System.out.print(iter.next() + " ");
			}
			System.out.println();
			
			
						
		}//전체 for문
	}
}
