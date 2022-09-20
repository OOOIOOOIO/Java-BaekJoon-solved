package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K번째수_1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		// index >= 1
		long low = 1;
		long high = K;
		
		// lower-bound
		while(low < high) {
			
			long mid = (low + high) / 2;	// 임의의 x(mid)를 중간 값으로 잡는다.
			long cnt = 0;
			
			/*
			 *  임의의 x에 대해 i번 째 행을 나눔으로써 x보다 작거나 같은 원소의 개수를 구한다
			 *  이 때 각 행의 원소의 개수가 N(열 개수)를 초과하지 않는 선에서 합해주어야 한다.   
			 */
			for(int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}
			
			// Key값(K)가 cnt보다 작다는 것은 구해야 할 값이 mid 이하라는 뜻
			if(K <= cnt) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		
		System.out.println(low);
	}
}
