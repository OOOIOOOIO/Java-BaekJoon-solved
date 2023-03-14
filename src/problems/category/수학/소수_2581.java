package problems.category.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 소수_2581 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[100001];
		
		int M = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		int idx = 0;
		int sum = 0;
		
		for(int i = M; i <= N; i++) {
			boolean flag = true;
			if(i == 1)  continue;
			
			if(i == 2 && N != 2) {
				arr[idx] = i;
				sum += arr[idx++];
				continue;
			}
			
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				arr[idx] = i;
				sum += arr[idx++];
			}
			
			
		}
        if(idx == 0){
            System.out.println("-1");    
                
        }
        else{
        System.out.println(sum);
		System.out.println(arr[0]);    
        }
		
		
	}
}
