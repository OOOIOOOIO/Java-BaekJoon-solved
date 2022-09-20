package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110 {
	
	public static int distance(int[] cordi, int N, int mid) {
		// 시작 위치
		int current = cordi[0];
		// 공유기의 개수
		int cnt = 1;
		for(int i = 1; i < N; i++) {
			// 집과 집사이의 거리
			int dis = cordi[i] - current;
			if(dis >= mid) {
				cnt++;
				current = cordi[i];
			}
			
		}
		return cnt;
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 집 개수
		int N = Integer.parseInt(st.nextToken());
		// 공유기 개수
		int C = Integer.parseInt(st.nextToken());
		
		//집의 좌표
		int[] cordi = new int[N];
		for(int i = 0; i < N; i++) {
			cordi[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(cordi);
		
		// 길이
		int low = 1;
		int high = cordi[N-1] - cordi[0] + 1; //  upper 방식이기 때문에 최댓값에 +1을 해준다.
		while(low < high) {
			int mid = (high + low) / 2;
			//비교할 key값은 집과 집 사이의 길이. 그 길이 만큼 설치할 수 있는 공유기 개수
			if(distance(cordi, N, mid) >= C) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		
		System.out.println(low - 1);

	}
}
