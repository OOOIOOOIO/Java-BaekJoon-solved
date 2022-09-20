package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 나무 수 N
 * 가져갈 필요 길이 M
 * 높이 H / up down
 * 나무길이 - H = 가져갈 길이
 * 가져갈 최소길이 M 최대높이 H
 */
public class 나무자르기_2805 {
	
	static long upper(int[] arr, int key, int max) {
		long low = 0;
		long high = max;
		long mid = 0;
		while(low < high) {
			long sum = 0;
			mid = (high + low) / 2;
			
			for(int i = 0; i < arr.length; i++) {
				long value = arr[i] - mid;
				if( value> 0) {
					sum += value;
				}
			}
			
			if(sum >= key) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
			
		}
		return low -1;
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N M
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 나무들
		st = new StringTokenizer(br.readLine());
		int[] trees = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(trees[i] > max) {
				max = trees[i];
			}
		}
		
		System.out.println(upper(trees, M, ++max));
		
	}
	

}
