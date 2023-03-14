package problems.category.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ATM_11399 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
	
		Queue<Integer> queue = new PriorityQueue<Integer>();
		
		int sum = 0;
		
		// 사람 수
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int[] store = new int[N];
		
		// 시간 넣기
		for(int i = 0 ; i < N; i++) {
			
			store[i] = Integer.parseInt(st.nextToken());
		}
		
		// Category.정렬
		Arrays.sort(store);
		
		for(int i = 0; i < N; i++) {
			
			sum += store[i] * (N - i);
		}
		
		
		System.out.println(sum);
	}
}
