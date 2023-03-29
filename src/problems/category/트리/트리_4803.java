package problems.category.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리_4803 {
	
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int cnt, vCnt, eCnt;
	
	static void dfs(int num) {
		visited[num] = true;
		// 정점의 개수
		vCnt++;
		// 정점 하나하나가 가진 간선의 개수, 양방향으로 연결되어 있으니 .size()를 통해 구한다.
		// 만약 순환이라면 vCnt = (eCnt / 2) + 1를 만족하지 못한다
		eCnt += graph[num].size();
		
		for(int item : graph[num]) {
			if(!(visited[item])) {
				dfs(item);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int caseNum = 1;
		
		
		while(true) {
			// 노드와 간선의 수
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n == 0 && m == 0) break;
			
			// 매번 새로 생성
			graph = new ArrayList[n+1];
			visited = new boolean[n+1];
			
			for(int i = 0; i <= n; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			
			// 간선, 트리는 양방향 연결, 그럼 루트와 리프 빼고는 간선이 2개씩 담긴다
			while(m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				graph[v1].add(v2);
				graph[v2].add(v1);
				
			}
			
			cnt = 0;
			// 모든 노드 검사
			for(int i = 1; i <= n; i++) {
				if(!(visited[i])) {
					vCnt = 0;
					eCnt = 0;
					dfs(i);
					if(vCnt == (eCnt / 2) + 1) cnt++;
					
				}
			}
			
			//
			if(cnt < 1) {
//				System.out.println("Case " + caseNum + ": No trees.");
				sb.append("Case " + caseNum + ": No trees.").append("\n");
			}
			else {
				if(cnt == 1) {
//					System.out.println("Case " + caseNum + ": There is one tree.");
					sb.append("Case " + caseNum + ": There is one tree.").append("\n");
				}
				else {
//					System.out.println("Case " + caseNum + ": A forest of " + cnt + " trees.");
					sb.append("Case " + caseNum + ": A forest of " + cnt + " trees.").append("\n");
				}
			}
			
			caseNum++;
			
		}
		
		System.out.println(sb);
	}
}
/*

 싸이클이 있는지 확인하는 법 
 
 노드의 개수 n <= 500
 간선의 개수 m <= n(n-1)/2
 
 n = 1, m <= 1(0) / 2 = 0
 
 n = 2, m <= 2(1) / 2 = 1
 
 n = 3, m <= 3(2) / 2 = 3
 
 n = 6, m <= 6(5) / 2 = 15 맞네 
*/