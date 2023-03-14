package problems.category.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_2_15650 {
	static StringBuilder sb = new StringBuilder();
//	static boolean[] visited;
//	static boolean[] cnt;
	static int[] seq;
	static int N, M;
	static int j;
	
//	static void dfs(int depth, int start) {
//		if(depth == M) {
//			
//			for(int val : seq) {
//				sb.append(val).append(" ");
//			}
//			sb.append("\n");
//			return;
//		}
//		
//		
//		for(int i = start; i <= N; i++) {
//
//			seq[depth] = i;
//			
//			dfs(depth + 1, i + 1);
//			
//				
//			}
//			
//	}
	static void dfs(int depth) {
		if(depth == M) {
			
			for(int val : seq) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i = 1; i <= N; i++) {
			
			seq[depth] = i;
			
			dfs(depth + 1);
			
			
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
//		visited = new boolean[N];
//		boolean[] cnt = new boolean[N];
		seq = new int[M];
		
//		for(int i = 0; i < N; i++) {
//			dfs(i);
//		}
		
		dfs(0);
		System.out.println(sb);
	}
}
/*


*/