package problems.category.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두용액_2470 {
	static String[] arr;
	static int[] seq;
	static int s;
	static int a;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = br.readLine().split(" ");
		
		seq = new int[N];
		
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(arr[i]);
		}
		
		Arrays.sort(seq);
		
		int i = 0;
		int j = N -1;
		
		while(i < j) {
			int sum = seq[i] + seq[j]; 
			int temp = Math.abs(sum);
			
			if(temp < min) {
				min = temp;
				a = seq[i];
				s = seq[j];
			}
			
			if(sum > 0) j--;
			else i++;
			
			
		}
		
		System.out.println(a);
		System.out.println(s);
	}
}
