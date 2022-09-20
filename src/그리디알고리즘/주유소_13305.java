package 그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 주유소_13305 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		// 도시 개수
		int N = Integer.parseInt(br.readLine());
		
		// 길이
		long[] dist = new long[N-1]; 
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N-1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		
		// 가격
		long[] price = new long[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N; i++) {
			price[i] = Long.parseLong(st.nextToken());
		
		}
		
		long sum = 0;
		long minCost = price[0];	// 이전 까지의 과정 중 주유 최소 비용 
 
		for(int i = 0; i < N - 1; i++) {
		
			/*
			 *  현재 주유소가 이전 주유소의 기름값보다 쌀 경우
			 *  minCost를 갱신해준다. 
			 */
			if(price[i] < minCost) {
				minCost = price[i];
			}
			
			sum += (minCost * dist[i]);
		}
		
		System.out.println(sum);
	}
	
}
