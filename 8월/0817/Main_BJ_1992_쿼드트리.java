package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1992_쿼드트리 {
	
	static int N;
	static int[][] board;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		
		divide(0, 0, N);
		System.out.println(sb);
	}
	
	
	private static void divide(int x, int y, int size) {
		
		if(allSame(x, y, size)) {
			sb.append(board[x][y]);
		}
		
		else {
			int mid = size/2;
			sb.append("(");
			divide(x, y, mid);			//왼쪽 위
			divide(x, y+mid, mid);		//오른쪽 위
			divide(x+mid, y, mid); 		//왼쪽 아래
			divide(x+mid, y+mid, mid);	//오른쪽 아래
			sb.append(")");
		}
		
	}
	
	
	private static boolean allSame(int x, int y, int size) {
		
		if(size == 1) {
			return true;
		}
		else {
		
			int num = board[x][y];
			
			for(int i=x;i<x+size;i++) {
				for(int j=y;j<y+size;j++) {
					if(board[i][j] != num) {
						return false;
					}
				}
			}
			return true;
		}
		
	}
	
	
}
