package 그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
	
	static int N;
	static int min = Integer.MIN_VALUE;
	static int arr[][];
	static int dp[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		// 회의 개수
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		
		// 생성
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(time2());
		
		
//		System.out.println(min);
		
	}
	
	static int time2() {
		
		// 다차원 배열일 경우 2차원은 <int[]> / 3차원은 <int[][]> 이런 식으로 들어가게 되며
		// 
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			// 끝나는 시간([1] 1열)을 기준으로 오름차순 정렬, 만약 값이 같을 경우 시작시간([0] 0열)을 오름차순 정렬 
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		int start = 0;
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			
			if(arr[i][0] >= start) {
				cnt++;
				start = arr[i][1];
			}
		}
		
		return cnt;
	}
	
	
	
	//정렬하지 않고 이렇게 돌리면 시간초과 남 쓰발
	static void time() {
		
		
		for(int j = 0; j < N; j++) {
			
			int start = arr[j][1];
			int cnt = 1;
			
			for(int i = 0; i < N; i++) {
				// 시간이 안맞을 때
				if(arr[i][0] < start) continue;
				
				if(arr[i][0] >= start) {
					cnt++;
					start = arr[i][1];
				}
			}
			if(cnt >= min) {
				
				min = cnt;
			}
			
			
		}
		
	}
	
}
