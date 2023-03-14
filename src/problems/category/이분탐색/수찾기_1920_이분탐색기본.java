package problems.category.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수찾기_1920_이분탐색기본 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] strA = br.readLine().split(" "); 
		int M = Integer.parseInt(br.readLine());
		String[] strB = br.readLine().split(" ");
		
		int[] intA = new int[N];
		int j = 0;
		
		for(String data : strA) {
			intA[j++] = Integer.parseInt(data);  
		}
		
		
		Arrays.sort(intA);
		
		for(int i = 0; i < M; i++) {
//			System.out.println(intA[i]);
			if(Arrays.binarySearch(intA, Integer.parseInt(strB[i])) >= 0) {
				sb.append(1).append("\n");
//				System.out.println(Arrays.binarySearch(intA, Integer.parseInt(strB[i])));
			}
			else {
				sb.append(0).append("\n");
//				System.out.println(Arrays.binarySearch(intA, Integer.parseInt(strB[i])));
			}
		}
		System.out.println(sb);
		
	}
}
