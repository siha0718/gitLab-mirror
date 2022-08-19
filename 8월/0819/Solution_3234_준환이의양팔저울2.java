import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울2 {

	static int T, N, res;
	static int[] weight;
	static int[] numbers;
	static boolean[] isSelected;
	static boolean[] isChecked;
	static int left, all;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			isSelected = new boolean[N];
			isChecked = new boolean[N];
			numbers = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				all += weight[i];
			}		
			

			perm(0);
			System.out.println("#" + tc + " " + res);
			
			
		}//end tc 		
	
		
	}//main
	
	
	private static void check(int start) {
		
		int right = all-left;		// 총합 - 왼쪽 저울에 올라간 무게추의 합 = 오른쪽 저울 >>>> 순서를 고려하지 못함 
		
		if(right <= left) {			// 오른쪽 저울이 왼쪽 저울보다 작으면 결과값을 증가시켜주는 로직으로 진행했으나, 
									// 오른쪽 저울에 절대 먼저 무게추가 올라가선 안된다는 조건을 무시하게 됨
			res++;
			return;
		}
		
		for(int i=start;i<numbers.length;i++) {
			
			left += numbers[i];
			isChecked[i] = true;
			check(i+1);
			isChecked[i] = false;
			left -= numbers[i];

		}
		
	}


	//순열 구하기
	private static void perm(int cnt){		

		if(cnt==N) {	
			check(0);
			return;
		}
		
	
		for(int i=0;i<N;i++) {			
			if(isSelected[i]) continue;	
			numbers[cnt] = weight[i];
			isSelected[i] = true;
			perm(cnt+1);		
			isSelected[i] = false;
		}
	}
	

}//end class
