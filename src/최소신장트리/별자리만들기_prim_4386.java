package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/*
3
1.0 1.0
2.0 2.0
2.0 4.0
 */
public class 별자리만들기_prim_4386 {
	
	static class Star {
		int starNum;
		double cost;
		
		public Star(int starNum, double cost) {
			this.starNum = starNum;
			this.cost = cost;
		}
	}
	
	static int n;
	static double[][] map;
	static ArrayList<ArrayList<Star>> graph;
	static boolean visited[];
	static double sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		map = new double[n+1][2];
		
		// 좌표 받기
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
				
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			map[i][0] = x;
			map[i][1] = y;
		}
		
		// 선언
		graph = new ArrayList<ArrayList<Star>>();
		
		visited = new boolean[n+1];
		
		// 생성
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Star>());
		}
		
		// 한 좌표와 모든 좌표의 거리 계산 및 연결
		for(int i = 1; i <= n; i++) {
			for(int j = i+1; j <= n; j++) {
				double dist = Math.sqrt(Math.pow(map[i][0] - map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2));
				graph.get(i).add(new Star(j, dist));
				graph.get(j).add(new Star(i, dist));
			}
		}
		
		prim();
		
//		System.out.println(String.format("%.2f", sum));
		System.out.printf("%.2f", sum);
	}
	
	static void prim() {
		Queue<Star> queue = new PriorityQueue<Star>(new Comparator<Star>() {
			@Override
			public int compare(Star o1, Star o2) {

				return (int)(o1.cost - o2.cost);
			}
		});
		
		queue.offer(new Star(1, 0));
		
		
		
		while(!(queue.isEmpty())) {
			
			Star curr = queue.poll();
			
			// 방문한 적 있으면 위로
			if(visited[curr.starNum]) continue;
			
			// 여기서 방문 여부 결정
			visited[curr.starNum] = true;
			
			sum += curr.cost;
			
			for(Star item : graph.get(curr.starNum)) {
				if(!(visited[item.starNum])) {
					queue.offer(new Star(item.starNum, item.cost));
				}
			}
		
		}
		
	}
}














