package problems.category.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기_1929 {
	
	static boolean[] prime;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// M이상 N이하의 소수 구하기
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// 에라토스테네스 기법으로 소수 구하기
		// 탐색 범위는 시작 ~ target의 제곱근
		// 왜 루트target이냐면 만약 target의 약수가 있다면 
		// 무조건 제곱근 보다 작거나 같은 것이기 때문이다.(2 제외) target = 9, 루트target은 3
		// 그리고 boolean 타입의 배열을 생성해 숫자의 배수 또한 거른다.
		
		// [target]이 들어가야하니까 + 1
		prime = new boolean[N + 1];
		
		// true = 소수 아님, false = 소수
		prime[0] = prime[1] = true;
		
		get_prime();
//		get_prime2();
		
		for(int i = M; i <= N; i++) {
			
			// prime[i] == false : 소수
			if(!prime[i]) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
	// 소수를 찾고 다시 main에서 돌리는 법
	static void get_prime() {
		
		for(int i = 2; i <= Math.sqrt(N); i++) {
				
			if(prime[i]) continue;
			
			// i^2 부터 target까지 i의 배수만큼 검사
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
			
		}
	}
	
	// 바로바로 하는 법
	static void get_prime2() {
		
		for(int i = 2; i <= N; i++) {
			
			if(prime[i]) continue;
			
			if(i >= M) sb.append(i).append("\n");
				
			for(int j = i + i; j < prime.length; j += i) {
				prime[j] = true;
			}
			
		}
	}
}
