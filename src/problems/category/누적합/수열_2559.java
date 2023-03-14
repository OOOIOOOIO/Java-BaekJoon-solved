package problems.category.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열_2559 {
	static int[] arr;
	static int[] temp;
	static int N, K;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		temp = new int[N - K + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N-K+1; i++) {
			for(int j = 0; j < K; j++) {
				temp[i] += arr[i+j];
			}
			
			if(temp[i] > max) {
				max = temp[i];
			}
		}
		
		
//		for(int i = 0; i < temp.length; i++) {
//			System.out.println(temp[i]);
//		}
		
		System.out.println(max);
	}
}
