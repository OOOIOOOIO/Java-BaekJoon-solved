package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_4_15652 {
	static int N, M;
	static int[] seq;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int before, int depth) {
		
		// 종료
		if(depth == M) {
			// 여기서 출력
			for(int item : seq) {
				sb.append(item + " ");
			}
			sb.append("\n");
			return;
		}		
		
		for(int i = before; i < N; i++) {

			seq[depth] = i + 1;
			
			dfs(before,depth + 1);
			
			before++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 수열 생성
		seq = new int[M];
		
		dfs(0, 0);
		System.out.println(sb);
	}
	
}
