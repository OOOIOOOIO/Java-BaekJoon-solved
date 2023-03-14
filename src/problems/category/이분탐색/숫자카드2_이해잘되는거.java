package problems.category.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * upper_bound, lower_bound
 * low = 0(시작점)
 * high = 배열길이  + 1
 * 
 * 만약 찾는 key 값이 없으면
 *  
 * lower도 upper처럼 한 칸 늘어난 값을 리턴한다.
 * 만약
 * 
 * 0 1 2 3 4 5 6 7 8--> index
 * 1 1 1 3 3 3 4 5 가 있을 때 찾는 key값이 2라 하면
 * 
 * return idex값은 "3"으로 1이 존재하는 마지막 index+1 이고
 * 
 * 만약 찾는 key값이 8이라 하면 return index값은 "8"로 마지막 비어있는 칸을 return한다.
 * 
 * 

10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10

 */

public class 숫자카드2_이해잘되는거 {
	
	static int lower_bound(int[] card, int key) {
		int low = 0;
		int high = card.length;
		
		while(low < high) {
			int mid = (high + low) / 2; // left + (right - left) / 2
			if(key <= card[mid]) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		
		return low;
	}
	
	
	static int upper_bound(int[] card, int key) {
		int low = 0;
		int high = card.length;
		
		while(low < high) {
			int mid = (high + low) / 2;
			if(key >= card[mid]) {
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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
	 
		Arrays.sort(card);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(upper_bound(card, key) - lower_bound(card, key) + 1).append(" ");
		}
		
		System.out.println(sb);
		
		
		

	}
}
