package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 트리의부모찾기_BFS_11725 {
	static class Graph{
		int vCnt;
		int eCnt;
		ArrayList<ArrayList<Integer>> adList;
		LinkedList<Integer> queue;
		int[] parents; 
		
		public Graph(int num) {
			vCnt = num;
			
			// vertex 수 + 1;
			adList = new ArrayList<>();
			
			parents = new int[vCnt + 1];
			
			// vertex수+1 만큼 만들기 index가 N까지 있으니 / vCnt+1
			for(int i = 0; i <= vCnt; i++) {
				adList.add(new ArrayList<Integer>());
			}
		}
		
		// vertex끼리 연결하기 
		// 양방향 연결!!!! 
		public void addVertex(int v1, int v2) {
				adList.get(v1).add(v2);
				adList.get(v2).add(v1);
				
		}
		
		
		//parent[자식] = 부모
		public void bfs(ArrayList<ArrayList<Integer>> adList, int[] parents, int start) {
			queue = new LinkedList<Integer>();
			
			queue.offer(start);
			
			// 큐에는 부모만 넣어준다. 첫번째 루트인 1을 넣고 
			// 1을 부모(parent)로 가진 자식들(item)이 있다면 자식들을(item) 큐에 넣는다.
			// 큐에 넣어진 item들이 부모가 되어 다시 이 과정을 반복한다. 부모의 자식들을 먼저 촤르르르르르륵 살피니까 
			while(!queue.isEmpty()) {
				
				int parent = queue.poll();
				
				for(int item : adList.get(parent)) {
					if(parents[item] == 0) {
						parents[item] = parent;
						queue.offer(item);
					}
				}
			}

//							<일반 bfs>
//			bfs(int vertex){
//			
//				vertex는 부모
//				v2 = 자식
//				
//				queue = new LinkedList<Integer>();
//				queue.offer(vertex);
//				
//				visited[vertex] = true
//						
//				while(!queue.isEmpty()) {
//					for(int v2 : adList.get(queue.poll())) {
//						if(!visited[v2]) {
//							visited[v2] = true;
//							queue.offer(v2);
//						}
//					}
//					
//				}
//			}		
		}
		
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); 
		Graph graph = new Graph(N);
		
		// vertex N-1개 만듬 
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());

			graph.addVertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
//		int start = 1;
		
		graph.bfs(graph.adList, graph.parents, 1);
		
		
		for(int i = 0; i <= N; i++) {
			System.out.println(graph.parents[i]);
		}
		
		System.out.println();
		
		for(int i = 2; i <= N; i++) {
			System.out.println(graph.parents[i]);
		}
		
		
	}
}
