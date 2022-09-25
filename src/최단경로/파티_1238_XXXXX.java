package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 파티_1238_XXXXX {
	
	static class Node{
		int nodeNum;
		int cost;
		
		public Node() {;};
		
		public Node(int nodeNum, int cost) {
			this.nodeNum = nodeNum;
			this.cost = cost;
		}
		
		
	}
	static ArrayList<ArrayList<Node>> graph;
	static int[] go;
	static int[] back;
	static int N, M, X;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수 == 마을 수
		M = Integer.parseInt(st.nextToken()); // 도로
		X = Integer.parseInt(st.nextToken()); // 파티하는 마을
		
		// 초기화
		graph = new ArrayList<ArrayList<Node>>();
		go = new int[N+1];
		back = new int[N+1];
		
		for(int i = 0; i <= M; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i <= N; i++) {
			go[i] = Integer.MAX_VALUE;
			back[i] = Integer.MAX_VALUE;
		}
		
		// 연결
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken()); // 학생 수 == 마을 수
			int node2 = Integer.parseInt(st.nextToken()); // 파티하는 마을
			int cost = Integer.parseInt(st.nextToken()); // 도로
			
			graph.get(node1).add(new Node(node2, cost));
			
		}	
		
		
	}
	
}
