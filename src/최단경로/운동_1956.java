package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 운동_1956 {
	

	static int V, E;
	static int[][] graph;
	static int INF = 1073741823;
	static int result = INF;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 선언
		graph = new int[V+1][V+1];
		
		// 초기화
		for(int[] item : graph) {
			Arrays.fill(item, INF);
		}
		
		// 간선 연결
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
//				graph[v1][v2] = cost;
			graph[v1][v2] = Math.min(graph[v1][v2], cost);
			
		}
		
		
		System.out.println(floydWarshall());
		
	}	
	
	
	
	static int floydWarshall(){
		for(int i = 1; i <= V; i++) { // 경유지
			for(int j = 1; j <= V; j++) { // 시작지
				for(int k = 1; k <= V; k++) { // 도착지
                    if (i == j) continue;
					if(graph[j][k] > graph[j][i] + graph[i][k]) {
						
						graph[j][k] = graph[j][i] + graph[i][k];
					}
					
//					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
						
				}
			}
		}
		// 자기 자신의 가중치를 확인해보면 된다. 여기선 INF로 초기화를 하였으니 result가 INF일 경우 사이클이 없다는 뜻이다.
		// 다른 방법으로는 서로에게 가는 경로가 있다면, 사이클이 존재한다는 뜻.
		for(int i = 1; i <= V; i++) {
			result = Math.min(graph[i][i], result);
		}
        
		return result == INF ? -1 : result;
	}
	
	
}
// 다른 방법으로는 서로에게 가는 경로가 있다면, 사이클이 존재한다는 뜻.