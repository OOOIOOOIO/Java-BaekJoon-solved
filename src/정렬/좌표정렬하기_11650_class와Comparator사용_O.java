package 정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Arrays.sort를 Comparator 익명 클래스를 이용하여 구현 

// Arrays.sort(배열, new Comparator<비교할 대상이 있는 곳의 타입>(){compare 재정의});
// Arrays.sort(클래스 배열, new Comparator<클래스>(){compare 재정의});
// Arrays.sort(arr, new Comparator<int[]>(){compare 재정의{}; (int[] arr= new int[])

class Cordinate{
	int x; // 여기에 private을 붙이면 다른 클래스 에서는 getter로 접근하지 않는 한 쓰지도 못 하고 수정도 못 함
	int y;
	
	public Cordinate() {;}
	
	public Cordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		
		return x + " " + y; 
	}
}


public class 좌표정렬하기_11650_class와Comparator사용_O {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		int N = sc.nextInt();
	
		Cordinate[] cor = new Cordinate[N];
		
		
		// 좌표 받기
		for(int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			cor[i] = new Cordinate(a, b);
		}
			
		// 정렬하기 Comparator 익명 클래스로 구현 
		// int x, y가 Cordinate라는 클래스 안에 정의가 되어있으므로 Cordinate[]가 아니라 Cordinate다.
		Arrays.sort(cor, new Comparator<Cordinate>() { 
			@Override
			public int compare(Cordinate o1, Cordinate o2) {
				if(o1.x == o2.x) return o1.y - o2.y;
				
				else return o1.x - o2.x;				
			};		
		});
		
		// 출력하기 
		for(int i = 0; i < N; i++) {
//			System.out.println(cor[i].y);
//			System.out.println("" +cor[i].x + " " + cor[i].y);
			System.out.println(cor[i]);
		}
		
	}
}
