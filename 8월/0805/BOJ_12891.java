package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891 {
	static int[] required = new int[4];
	static int[] count = new int[4];
	static String dna = "ACGT";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		String str = br.readLine();
		st = new StringTokenizer(br.readLine(), " ");
		
		// 조건 개수 담기
		for (int i = 0; i < required.length; i++) {
			required[i] = Integer.parseInt(st.nextToken());
		}

		// 맨 처음 P칸 검사
		for (int i = 0; i < P; i++) {
			count[dna.indexOf(str.charAt(i))]++;
		}
		if (validCheck())
			ans++;

		// 한 칸씩 전진하며 이전 문자를 빼고 추가된 문자를 더한 후 유효성 검사
		for (int i = 1; i < str.length() - P + 1; i++) {
			count[dna.indexOf(str.charAt(i - 1))]--;
			count[dna.indexOf(str.charAt(i + P - 1))]++;

			if (validCheck())
				ans++;
		}

		System.out.println(ans);
	}

	// 부분문자열이 유효한지 확인하는 메서드
	static boolean validCheck() {
		boolean valid = true;
		for (int j = 0; j < 4; j++) {
			if (count[j] < required[j]) {
				valid = false;
			}
		}
		return valid;
	}
}
