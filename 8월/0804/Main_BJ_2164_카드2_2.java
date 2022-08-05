package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_2164_카드2_2 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());

		
		int n=1;
		while(n<N) {
			n*=2;
		}
		n/=2;
		
		if(N==1)	System.out.println(1);
		System.out.println((N-n) * 2);
	}
}
