package problems.category.dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {
	
	static LinkedList<Integer>[] list;
	static int cnt = 0;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		/*
		 * 공간 확보
		 */
		list = new LinkedList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		/*
		 * 연결
		 */
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			list[v1].add(v2);
			list[v2].add(v1);
			
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				check(i);
				cnt++;
				
			}
			
		}
		
		System.out.println(cnt);
		
	}
	
	public static void check(int curr) {

		// 방문)
		visited[curr] = true;

		for(int next : list[curr]) {
			if(!visited[next]) {
				check(next);
			}
			
		}
		
		
	}
}
