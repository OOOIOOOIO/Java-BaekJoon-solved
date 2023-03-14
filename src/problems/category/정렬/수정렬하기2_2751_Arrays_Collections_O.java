package problems.category.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 수정렬하기2_2751_Arrays_Collections_O {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		// Arrays.sort와 Collections.sort에 대해 정확히 알기 최악의 경우를 생각하자!!!!
		Collections.sort(arr);
		
		
		StringBuilder sb = new StringBuilder();
		
		// ArrayList 혹은 배열에 있는 걸 뽑을 때 이렇게 뽑아야하나보다.
		for(int i : arr) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
		
	}
}

//		for(int i = 0; i < N; i++) {
//			System.out.println(arr.get(i));
//		} 시간 초과

//		for(int i : arr) {
//			System.out.println(i);
//		} 시간 초과