package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 두수의합_3273 {
	
	static String[] arr;
	static int[] seq;
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = br.readLine().split(" ");
		
		int X = Integer.parseInt(br.readLine());
		seq = new int[N];
		
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(arr[i]);
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(seq[i] + seq[j] == X){
                  cnt++;  
                  break;
                } 
                
			}
		}
		
		System.out.println(cnt);
	}
}
