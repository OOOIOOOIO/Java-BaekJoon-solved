package problems.category.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 소수의_연속합_1664 {
	
	static int N;
	static boolean[] prime;
	static ArrayList<Integer> pNum = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		
		
		prime = new boolean[N+1];   
		
		// true면 소수 X, false면 소수
        prime[0] = prime[1] = true;       
        
        for(int i=2; i*i<=N; i++){
            if(!prime[i]) {
            	for(int j = i*i; j <= N; j += i) {
            		prime[j]=true;                
            	}
            }
        }           
        
        for(int i=1; i<=N;i++){
        	if(!prime[i]) {
        		pNum.add(i);     
        	}
        }
        
        // 2. 연속합으로 주어진 정수 구할 수 있는지 판별
        int start=0, end=0, sum=0, cnt=0;
        
        while(true) {
        	if(sum >= N ) {
        		sum -= pNum.get(start++);
        	}
        	else if(end == pNum.size()) {
        		break;
        	}
        	else {
        		sum += pNum.get(end++);       	
        	}
        	
        	
        	if(N==sum) cnt++;        	
        }

        System.out.println(cnt);	
    }	
}