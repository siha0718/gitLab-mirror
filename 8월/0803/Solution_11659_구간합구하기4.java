package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_11659_구간합구하기4 {

	public static void main(String[] args) throws Exception {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[N+1];	
		int[] nsum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1;i<N+1; i++) {
			nsum[i] = nsum[i-1] + num[i];
		}

		
		
		for(int tc=0;tc<M;tc++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int i = (Integer.parseInt(st.nextToken()));
			int j = (Integer.parseInt(st.nextToken()));
			sum = nsum[j] - nsum[i-1];
			
			
		}


	}

}
