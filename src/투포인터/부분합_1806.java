package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분합_1806 {
	
	static int[] arr;
	static int length = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		int i = 0;
		int j = 0;
		int sum = 0;
		
		
		while(true) {
			
//			if(j == N) break; 여기에 해주면 i가 갈 수 있는 경우를 구하지 못한다.
			
			if(sum >= S) {
				sum -= arr[i++];
				length = Math.min(length, j - i + 1);
			}
			else if(j == N) {
				break;
			}
			else {
				sum += arr[j++];
			}
		}
			
		System.out.println(length == Integer.MAX_VALUE ? 0 : length);
	}
}





