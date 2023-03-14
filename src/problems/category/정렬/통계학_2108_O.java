package problems.category.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 통계학_2108_O {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] countSort = new int[8001]; // 넣은 숫자들, 최빈값
		int median = 0; // 중앙값
		int max = Integer.MIN_VALUE; // 최소값
		int min = Integer.MAX_VALUE; // 최대값  범위
		int sum = 0;
		int range = 0;
		int count = 0;
		double avg = 0.0;
		int mode_max = 0;
		int mode_value = 0;
		boolean flag = false;
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			countSort[input + 4000]++; // 4000이 기준(==0)
			
			sum += input;
			
			if(input > max) {
				max = input;
			}
			
			if(input < min) {
				min = input;
			}
			
		}
		
		// 산술평균
		avg = Math.rint((double)sum / N);
		
		
		for (int i = min + 4000; i <= max + 4000; i++) { // counting sort는 인덱스가 값이니까
			
			if(countSort[i] > 0) {
				// 중앙값
				if(count <(N + 1) / 2) {
					count += countSort[i];
					median = i -4000;
				}
				
				// 최빈값
				// 최빈값이 들어오는 경우  
				if(countSort[i] > mode_max){
					mode_max = countSort[i]; 
					mode_value = i - 4000;
					flag = true; 
							
				}
				
				// 중복되는 경우 
				else if(mode_max == countSort[i] && flag == true) {
					mode_value = i - 4000;
					flag = false;
				}
				
				
			}
		}
		
		// 범위
		range = max + min*-1;
		
		sb.append((int)avg).append("\n");
		sb.append(median).append("\n");
		sb.append(mode_value).append("\n");
		sb.append(range).append("\n");
		
		System.out.println(sb);
		
		
	}
}
