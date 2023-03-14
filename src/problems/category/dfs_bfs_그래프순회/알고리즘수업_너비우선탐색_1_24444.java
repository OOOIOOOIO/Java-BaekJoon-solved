package problems.category.dfs_bfs_그래프순회;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알고리즘수업_너비우선탐색_1_24444 {

	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] order;
	static int idx = 1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		// 선언
		visited = new boolean[N+1];
		order = new int[N+1];
		graph = new ArrayList[N+1];
		
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph[v1].add(v2);
			graph[v2].add(v1);
			
		}
		for(int i = 0; i <= N; i++) {
			Collections.sort(graph[i]) ;
		}
		
		// 알고리즘 수업 너비 우선 탐색 2
//		for(int i = 0; i <= N; i++) {
//			Collections.sort(graph[i], new Comparator<Integer>() {
//				@Override
//				public int compare(Integer o1, Integer o2) {
//					return o2 - o1;
//				}
//			});
//		}
//		
		
		bfs(start);
		
		for(int i = 1; i <= N; i++) {
			System.out.println(order[i]);
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(start);

		visited[start] = true;
		
		while(!(queue.isEmpty())) {
			int curr = queue.poll();

			order[curr] = idx;
			idx++;
				
			for(int item : graph[curr]) {
				if(!(visited[item])) {
					visited[item] = true;
					queue.offer(item);
				}
			}
		}
	}
}
