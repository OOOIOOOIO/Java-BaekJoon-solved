package problems.category.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 배열로 받을까?
 */
import java.util.StringTokenizer;

public class 랜선_1654_XXX {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());;
		
		// 랜선 받기
		int[] data = new int[K];
		
		long max = 0;
		
		for(int i = 0; i < K; i++) {
			data[i] = Integer.parseInt(br.readLine());
			if(data[i] > max) {
				max = data[i];
			}
		}
		// upper bound : upper/lower bound는 배열의 길이를 + 1 해주어야 한다.
		// return 값에서 lower은 그대로 upper은 -1을 해준다
		max ++;
		
		long min = 0;
		long mid = 0;
		while(min < max) {
			mid = (max + min) / 2;
			
			long count = 0;
			for(int i = 0; i < data.length; i++) {
				count += (data[i] / mid);
			}
			if(count >= N) {
				min = mid + 1;
			}
			else{
				max = mid;
			}
		}
		System.out.println(min-1);
		
		
	}
}
