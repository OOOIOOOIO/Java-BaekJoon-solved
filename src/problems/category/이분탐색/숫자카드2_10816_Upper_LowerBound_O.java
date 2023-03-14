package problems.category.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class 숫자카드2_10816_Upper_LowerBound_O {
	static int lower_bound(int[] card, int key) {
		int left = 0;
		int right = card.length;
		
		while(left < right) {
			int mid = (right + left) / 2;
			if(key <= card[mid]) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		
		return left;
	}
	
	
	static int upper_bound(int[] card, int key) {
		int left = 0;
		int right = card.length;
		
		while(left < right) {
			int mid = (right + left) / 2;
			if(key < card[mid]) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
			
		}
		return left;
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
			sb.append(upper_bound(card, key) - lower_bound(card, key)).append(" ");
		}
		
		System.out.println(sb);
		
		
		

	}
}
