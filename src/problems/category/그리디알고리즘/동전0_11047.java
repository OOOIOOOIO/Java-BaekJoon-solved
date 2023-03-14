package problems.category.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전0_11047 {
	
	static int K;
	static int[] arr;
	static int cnt;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); 
		
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		
		ss();
		
		System.out.println(cnt);
		
	}
	
	static void ss() {
		
		
		while(K != 0) {
			
			int curr = 0;
			int val = 0;
			int min = Integer.MAX_VALUE;
			
			// for문을 통해 잔돈 확인
			for(int i = 0; i < arr.length; i++) {
				
				val = (Integer)(K / arr[i]);
				
				// val이 0인 경우 continue하기;
				if(val == 0) continue;
				
				if(val <= min) {
					min = val;
					curr = i;
				}
				
			}
			
			// for문이 끝나면 k 빼주기
			K -= arr[curr] * min;
			cnt += min;
		}
	}
}

// val이 작을수록 k를 큰 수로 나눌 수 있다는 뜻
