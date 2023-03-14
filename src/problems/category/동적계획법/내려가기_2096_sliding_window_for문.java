package problems.category.동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * Sliding Window 기법
 * 일정한 범위를 유지하며 이동하는 기법이다.
 * 예를 들어 긴 문자열에서 서로 다른 문자2개를 포함하는 Category.문자열 중 가장 긴 문자열을 구하시오가 있다.
 */
public class 내려가기_2096_sliding_window_for문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] maxDp = new int[3];
		int[] minDp = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int line_1 = Integer.parseInt(st.nextToken());
			int line_2 = Integer.parseInt(st.nextToken());
			int line_3 = Integer.parseInt(st.nextToken());

			if (i == 0) {
				maxDp[0] = minDp[0] = line_1;
				maxDp[1] = minDp[1] = line_2;
				maxDp[2] = minDp[2] = line_3;
			} else {
				// 최댓값을 구하는 dp 배열
				int tempMaxDp0 = maxDp[0], tempMaxDp2 = maxDp[2]; // dp[0], dp[2]가 먼저 초기화 되기 때문에 
				maxDp[0] = Math.max(maxDp[0], maxDp[1]) + line_1;
				maxDp[2] = Math.max(maxDp[1], maxDp[2]) + line_3;
				maxDp[1] = Math.max(Math.max(tempMaxDp0, maxDp[1]), tempMaxDp2) + line_2;

				// 최솟값을 구하는 dp 배열
				int tempMinDp0 = minDp[0], tempMinDp2 = minDp[2];
				minDp[0] = Math.min(minDp[0], minDp[1]) + line_1;
				minDp[2] = Math.min(minDp[1], minDp[2]) + line_3;
				minDp[1] = Math.min(Math.min(tempMinDp0, minDp[1]), tempMinDp2) + line_2;
			}
		}

		bw.write(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + " ");
		bw.write(Math.min(minDp[0], Math.min(minDp[1], minDp[2])) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}