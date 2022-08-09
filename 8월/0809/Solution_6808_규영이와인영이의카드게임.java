package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {
	
	static int T;
	static int[] gyu;
	static int win;
	
	static int n = 9;                           
    static int r = 9;                           
    static int[] inyoung = new int[r];	           
    static int[] answer = new int[r];           
    static boolean[] check = new boolean[n];    
    
    
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = null;
		
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			win = 0;
			st = new StringTokenizer(br.readLine());
			gyu = new int[9];
			boolean[] isUse = new boolean[19];
			
			for(int i=0;i<9;i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				isUse[gyu[i]] = true;
			}
			
			
			for(int i=1,j=0;i<19;i++) {
				if(!isUse[i])	inyoung[j++] = i;
			}
			
			perm(0);		
			System.out.printf("#%d %d %d\n", tc, win, (362880 - win));
		}
		
	}//main
	
	
	private static void perm(int depth) {
		if(r == depth) {
			
			int gsum = 0;
			int isum = 0;
			
			for(int i=0;i<r;i++) {
				if(gyu[i] > answer[i]) {
					gsum += (gyu[i] + answer[i]);
				}
				else {
					isum += (gyu[i] + answer[i]);
				}				
			}
			
			if(gsum > isum)	
				win++;
			
			return;
		}

        for (int i = 0; i < n; i++) {
            if(!check[i]) {
                check[i] = true;
                answer[depth] = inyoung[i];
                perm(depth + 1);
                check[i] = false;
            }
        }
	}

	
}//end class
