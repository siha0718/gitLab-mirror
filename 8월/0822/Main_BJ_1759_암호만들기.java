import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1759_암호만들기 {
	
	static int L, C;
	static String[] alpha;
	static String[] res;
	static boolean[] isChecked;
	static String check = "aeiou";
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new String[C];
		res = new String[L];
		isChecked = new boolean[C];
	
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			alpha[i] = st.nextToken();
		}
		
		Arrays.sort(alpha);
		
		comb(0, 0);
		
		
	}

	private static void comb(int start, int cnt) {
		
		if(cnt == L) {
			print(res);
			return;
		}

		
		for(int i=start;i<C;i++) {			
			res[cnt] = alpha[i];
			comb(i+1, cnt+1);
		}

		
	}

	private static void print(String[] list) {

		if(check(list)) {
			for(int i=0;i<list.length;i++) {
				System.out.print(list[i]);
			}
			System.out.println();
		}
	}

	
	
	private static boolean check(String[] list) {
		
		int num1 = 0;	//모음
		int num2 = 0;  	//자음
		for(int i=0;i<list.length;i++) {
			if(check.contains(list[i])) {
				num1+=1;				
			}
			else num2+=1;
		}
		
		if(num1 >= 1 && num2 >= 2)	return true;
		
		return false;
	}

	
	

		
}
