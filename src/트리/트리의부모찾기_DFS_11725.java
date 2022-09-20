package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 트리의부모찾기_DFS_11725 {
	
	static class Graph{
		int vCnt;
		int eCnt;
		ArrayList<ArrayList<Integer>> adList; // dfs에서 사용
		ArrayList<Integer>[] list; 			  // dfs2에서 사용
		int[] parents; 
		
		// 공간 생성
		public Graph(int num) {
			vCnt = num;
			
			// vertex 수 + 1;
			adList = new ArrayList<>();
			
			list = new ArrayList[vCnt+1];
			
			parents = new int[vCnt + 1];
			
			// vertex수+1 만큼 만들기 index가 N까지 있으니
			for(int i = 0; i <= vCnt; i++) {
				adList.add(new ArrayList<Integer>());
				
				list[i] = new ArrayList<Integer>();
				
			}
		}
		
		// vertex끼리 연결하기 
		// 양방향 연결!!!! 
		public void addVertex(int v1, int v2) {
				adList.get(v1).add(v2);
				adList.get(v2).add(v1);
				
				list[v1].add(v2);
				list[v2].add(v1);
		}
		
		
		// parent[자식] = 부모
		public void dfs(ArrayList<ArrayList<Integer>> adList, int[] parents, int start, int parent) {
			parents[start] = parent;
			
			// item에 arraylist 값이 담기고
			// item(자식)과 parent(부모) 값이 다르다면 밑으로 쭉쭉 내려간다~~ 
			for(int item : adList.get(start)) {
				if(item != parent) { // vistied역할을 parent가 하면서 도넹
					
					dfs(adList, parents, item, start); 
				}
			}
		}
		
		// parent[자식] = 부모
		// ArayList 배열로 할 경우
		public void dfs2(ArrayList<Integer>[] list, int[] parents, int start, int parent) {
			/// 부모노드를 저장하는 배열
			parents[start] = parent;
			
			// item에 arraylist 값이 담기고
			// item(자식)과 parent(부모) 값이 다르다면 밑으로 쭉쭉 내려간다~~ 
			// 첫 재귀 호출할 때 1의 자식들이 start 자리에 담기고 parent에는 1이 들어가면서 시작하게 된다. 
			for(int item : list[start]) {
				if(item != parent) {
					dfs2(list, parents, item, start);
				}
			}
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
		
		// vertex가 1부터 시작하니까 start(루트)에 1을 넣고, parent엔 0을 넣는다
		// 재귀를 돌면서 start는 자식이 되고 parent는 start(부모)가 된다.
//		int start = 1;
//		int parent = 0;
		graph.dfs(graph.adList, graph.parents, 1, 0);
		
		graph.dfs2(graph.list, graph.parents, 1, 0);
		
		
		for(int i = 0; i <= N; i++) {
			System.out.println(graph.parents[i]);
		}
		
		System.out.println();
		
		for(int i = 2; i <= N; i++) {
			System.out.println(graph.parents[i]);
		}
		
		
	}
}
