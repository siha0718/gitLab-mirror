package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_12891_DNA비밀번호 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuffer sb = new StringBuffer();
		
		int S, P;
		char[] dna;
		int[] num = new int[4]; //A,C,G,T의 최소 개수가 담긴 배열
		int[] check = new int[4];
		int cnt = 0;
		boolean isDna = false;
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		dna = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
			
		//0,1,2,3
		for(int i=0;i<=S-P;i++) {
			
			check = new int[4];
			isDna = false;			
			
			if(i+P >= S)	break;
			for(int j=0;j<i+P;j++) {	//0~2,,, 0, 1 1, 			
				
				switch(dna[j]) {
				case 'A':
					check[0] += 1;
					break;
				case 'C':
					check[1] += 1;
					break;
				case 'G':
					check[2] += 1;
					break;
				case 'T':
					check[3] += 1;
					break;
				}
			}			
			
			
			for(int k=0;k<4;k++) {
				if(check[k] < num[k]) {
					check[k] -= 1;
					break;
				} 				
				isDna = true;
				
			}
			
			if(isDna) cnt++;
			
		}
		
		
		System.out.println(cnt);

	}

}
