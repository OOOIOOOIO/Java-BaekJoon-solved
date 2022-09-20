package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경로찾기_11403_Floyd는dp고려_DFS로풀음 {
	
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean visited[];
	static int[][] map;
	static int[][] result;
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
        StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		// dfs 설정
//		dfsConfig();
		
		
		// dfs 실행
//		for(int i = 0; i < N; i++) {
//			dfs(i, i);
//			visited = new boolean[N];
//		}
		
		// Floyd
		map = new int[N][N];
		result = new int[N][N];
		
		// mapping
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
        // mapping이 잘 됐나~~
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		System.out.print(map[i][j]+" ");
        	}
        	System.out.println();
        }
        
        System.out.println();
        
        floyd();
		
        // result로 출력
        System.out.println("[result]");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// map으로 출력
		System.out.println("[map]");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		
		// 답은 근데 dfs로 풀음 
		// 약간 가중치 간선이 연결되어 있는지 -> 근데 모든 노드를 다 봐야한다? -> 플로이드 워셜
		
	}
	
	
	static void floyd() {
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					
					if(map[i][k] == 1 && map[k][j] == 1) {
						result[i][k] = 1; // ==1 && ==1 로 이어져 있기 때문에 현재 및 과거를 바탕으로 풀어나간다. 
						result[k][j] = 1;
						result[i][j] = 1;
						
						map[i][j] = 1; // 이미 이어져 있는 map을 기반으로 풀어나가기 때문에 연결된 곳만 찾으면 된다.
					}
				}
			}
		}
	}
	
	static void dfsConfig() throws IOException {
		// 초기화
		graph = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		visited = new boolean[N];
		result = new int[N][N];
		
		
		// 그래프 생성
		for(int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {

				if(temp[j].equals("1")) {
					// 방향 그래프
					graph[i].add(j);
				}
			}
		}
	}
	static void dfs(int currNode, int cri) {
		
		
		for(int nextNode : graph[currNode]) {
			if(!visited[nextNode]) {
				visited[nextNode] = true;
				result[cri][nextNode] = 1;
				dfs(nextNode, cri);
				//visited[nextNode] = false; // 이렇게 하면 시간 초과가 난다. 그냥 새로운 객체 만들어 주는게 시간적인 측면에선 훨씬 나은 듯?!
			}
		}
		
	}	
	
}

/*
 * 1, graph 만들기
 * 2, for문 돌리면서 0~n까지 dfs 돌리기. 이때 매번 visited new 해주기 or다녀와서 false 하기 어차피 재귀 다 끝나고 false가 되기 때무네 상관없음
 * 3, 만약 dfs에 들어오면 result에 1 해주기
 * 
 * dfs 시간초과
 * 모든 정점에서 모든 정점의 거리를 구하는 문제라네 --> 플로이드 워셜
 * 
 */
