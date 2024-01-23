package problems.category.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 	LIS(Longest Increasing Subsequence)
 * 최장 증가 부분 수열이란 주어진 수열에서 오름차순으로 정렬된 가장 긴 부분 수열을 찾는 문제이다.
 * 부분 수열이기 때문에 연속적이거나 유일할 필요는 없다.
 * (부분 수열을 쉽게 생각해보자면 최소값이 있는 위치부터 앞만 보고 찾으면 된다)
 *
 * 
 * 	풀이 방법은
 * - Dynamic Programming / O(N^2)
 * - Binary Search / O(NlogN)
 * 
 * 
 *   Dynamic Programming
 * 동적계획법은 2가지 방식이 있다.
 * Top-Down(Category.재귀)
 * Bottom_Up(반복문)
 * 
 * 수열을 정리할 배열 , list, ... 테이블 선언
 * max를 1로 정의함으로써 우선 부분수열의 최대 크기를 설정하고 원수열 배열을 만든다.
 * 정리할 테이블에 0을 미리 삽입해하여 최소 길이일 때를 대비한다.
 * 기존 수열을 반복문을 통해 i, i+1 번째 요소를 비교하면서 i+1이 더 클 경우 테이블에 LIS 길이를 추가한다.
 * 
 *  
 */


// Dynamic Programming
public class LIS_DP_가장긴증가하는부분수열_12015 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 각 위치에서의 LIS를 저장할 1차원 dp 테이블을 정의한다.
		int[] dp = new int[N];
		// 최대 LIS의 값.
		int max = 1;

		// 첫 번째 원소부터 N번째 원소까지 dp 테이블의 값을 채워 나간다.
		for (int i = 0; i < N; i++) {
			// 우선 해당 위치를 본인의 길이(1)로 초기화한다.
			dp[i] = 1;
			// 현재 원소의 위치에 대하여, 앞의 원소의 값을 비교하며 값을 갱신한다.
			for (int j = 0; j < i; j++) {
				// 만일 부분 수열이 증가할 가능성이 있다면
				if (arr[i] > arr[j]) {
					// dp 테이블에 저장된 LIS를 바탕으로 가장 큰 값을 dp[i]의 값으로 갱신한다.
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

			// 전체 수열에서 LIS의 값을 갱신한다.
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}
}




