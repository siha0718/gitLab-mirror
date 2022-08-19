
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234 {
	static int N, ans, chu[], arr[];
	static boolean selected[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			chu = new int[N];
			arr = new int[N];
			selected = new boolean[N];
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				chu[j] = Integer.parseInt(st.nextToken());
			}

			// 추에 올라갈 순서를 구하기 위한 순열
			perm(0);
			System.out.println("#" + i + " " + ans);
		}

	}

	static void perm(int count) {

		// 순서를 다 정했다면
		if (count == N) {

			// 정한 순서대로 저울에 올리기
			// 첫 무게 추를 오른쪽에 올리는 경우는 조건에 바로 위배되므로 고려하지 않아도 됨
			put(arr, 0, true, 0, 0);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				arr[count] = chu[i];
				perm(count + 1);
				selected[i] = false;
			}
		}
	}

	static void put(int[] arr, int count, boolean left, int leftSum, int rightSum) {

		if (left) {				   //left가 true이면, 
			leftSum += arr[count]; // 왼쪽에 올리는 경우
		} else {
			rightSum += arr[count]; // 오른쪽에 올리는 경우
		}

		// 무게 추를 올릴 때
		// 오른쪽 위에 올라가 있는 무게의 총합이
		// 왼쪽에 올라가 있는 무게의 총합보다 더 커져서는 안 된다.
		if (rightSum > leftSum)
			return;

		// 모든 무게 추를 올렸다면 ans 카운트 증가
		if (count == N - 1) {
			ans++;
			return;
		}

		// 왼쪽 저울에 다음 무게 추 올리기
		put(arr, count + 1, true, leftSum, rightSum);

		// 오른쪽 저울에 다음 무게 추 올리기
		put(arr, count + 1, false, leftSum, rightSum);

	}
}
