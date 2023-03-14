package problems.category.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_5_15654 {
	static int N, M;
	static int[] numbers;
	static int[] seq;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// N개 중 M개를 고르는 수열(오름차순)
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
				
		numbers = new int[N];
		seq = new int[M];
		visited = new boolean[N];
		
		String[] temp = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(numbers);
		
		dfs(0);
		System.out.println(sb.toString());
		
	}
	
	static void dfs(int depth) {
		if(depth == M) {
			// 종료
			for(int num : seq) {
				sb.append(num + " ");
			}
			
			sb.append("\n");
			return;
		}
		
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) { // 중복 방지, dfs
				visited[i] = true;
				seq[depth] = numbers[i];
				dfs(depth+1);
				visited[i] = false; // 다시 돌아야하기 때문에
			}

		}
		
	}

}
