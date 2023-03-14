package problems.category.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Cordinate2{ // 여기다 implements Comparable 후 compareTo 재정의를 해도 된다. 
	int x;
	int y;
	
	public Cordinate2() {;}
	
	public Cordinate2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		
		return x + " " + y; 
	}
	
}


public class 좌표정렬하기_11651_class와Comparator사용_O {
	public static void main(String[] args) throws IOException{
		// 스캐너 대신 버퍼리더와 토큰나이저 사용하기! 성능 차이가 어마어마함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		// 입력개수
		int N = Integer.parseInt(br.readLine());
		
		Cordinate2[] cor2 = new Cordinate2[N];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			cor2[i] = new Cordinate2(a, b);
//			cor2[i].x = a;
//			cor2[i].y = b; --> 에러남 
			
		}
		
		Arrays.sort(cor2, new Comparator<Cordinate2>() {
			@Override
			public int compare(Cordinate2 o1, Cordinate2 o2) {
				if(o1.y == o2.y) return o1.x - o2.x;
				
				else return o1.y - o2.y;
					
				}			
			
		});
		
		
		for(int i = 0; i < N; i++) {
			sb.append(cor2[i].x+ " " + cor2[i].y).append("\n");
//			System.out.println(cor2[i]); toString으로 출력
		}
		
		System.out.println(sb);
			
		
	}
}
