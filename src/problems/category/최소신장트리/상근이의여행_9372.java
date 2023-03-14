package problems.category.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 상근이의여행_9372 {
	static ArrayList<ArrayList<Integer>> tree;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			// 국가의 수, 비행기 종류
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 선언
			tree = new ArrayList<ArrayList<Integer>>();
			
			for(int i = 0; i <= N; i++) {
				tree.add(new ArrayList<Integer>());
			}
			
			visited = new boolean[N+1];
			
			// 연결
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				
				tree.get(v1).add(v2);
				tree.get(v2).add(v1);
			}
			cnt = 0;
			dfs(1);
			sb.append(cnt).append("\n");
			
		}
		System.out.println(sb);
		
	}
	
	static void dfs(int root) {
		
		visited[root] = true;
		
		
		for(int item : tree.get(root)) {
			if(!(visited[item])) {
				visited[item] = true;
				cnt++;
				dfs(item);
			}
		}
	}
}















