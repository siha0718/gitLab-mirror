package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_4012_요리사 {

	static int T, N;
	static int[][] foods;	
	static boolean[] visited;
	static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());			
		
		
		for(int tc=1;tc<=T;tc++) {					//테스트케이스 시작
			
			
			N = Integer.parseInt(br.readLine());			
			visited = new boolean[N];
			res = Integer.MAX_VALUE;				//케이스가 시작될때마다 꼭 초기화 해야함
	
			
			foods = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					foods[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			comb(0, 0);			
			System.out.printf("#%d %d\n", tc, res);
			
		}//end for
		
		

	}//main
	
	
	
	private static void comb(int start, int cnt) {
		
		if(cnt==N/2) {				// N/2개까지 모두 뽑았다면? 
			
			ArrayList<Integer> A = new ArrayList<>();
			ArrayList<Integer> B = new ArrayList<>();
			
			
			int sumA = 0;
			int sumB = 0;
			
			for(int i=0;i<N;i++) {
				if(visited[i]) {		
					A.add(i);			//현재 뽑힌 원소는 A리스트에 저장
				}	
				else {
					B.add(i);			//안뽑힌 원소는 B리스트에 저장
				}
			}			
			
			
			//시너지 계산
			for(int i=0;i<A.size()-1;i++) {
				for(int j=i;j<A.size();j++) {
					sumA += foods[A.get(i)][A.get(j)];		//각 리스트에 저장된 음식 번호를 foods 배열에 대입하여 각 그룹의 합계를 계산
					sumA += foods[A.get(j)][A.get(i)];
					sumB += foods[B.get(i)][B.get(j)];
					sumB += foods[B.get(j)][B.get(i)];	
				}
			}			
			
			
			
			res = Math.min(res, Math.abs(sumA - sumB));	 	//각 음식의 시너지의 차와 이전까지의 최소값을 비교하며 갱신
			
			return;			//다시 되돌아가며 원소 뽑기
			
		}
		
		
		//N까지의 모든 수에 대해,
		//이미 조합이 선택되었다면 선택하지 않기위해 visited함수를 사용하여 중복 추출을 방지함		
		for(int i=start; i<N;i++) {
			visited[i] = true;
			comb(i+1, cnt+1);
			visited[i] = false;			
		}
		
	}

	
	
}
