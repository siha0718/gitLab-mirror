package day0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_1158_요세푸스문제 {
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		for(int i=1;i<=N;i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		
		while(queue.size()!=1) {
			for(int i=0;i<K-1;i++) {
				queue.offer(queue.poll());
			}
			
			sb.append(queue.poll() + ", ");
						
		}
		
		sb.append(queue.poll() + ">");
		
		System.out.println(sb);
		
		
		
	}
	
}
