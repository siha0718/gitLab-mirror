package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2563_색종이 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		int cnt = 0;
		
		for(int tc=0;tc<N;tc++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for(int i=r;i<r+10;i++) {
				for(int j=c;j<c+10;j++) {
					if(paper[i][j] != 1) {
						paper[i][j] = 1;
						cnt += 1;
					}
				}
			}
			
			
		}
		
		System.out.println(cnt);
		
	}
}
