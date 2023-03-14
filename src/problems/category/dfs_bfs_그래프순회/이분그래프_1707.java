package problems.category.dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이분그래프_1707 {
	
	static ArrayList<Integer>[] graph;
	static int[] color;
	static int V, E;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 테스트 케이스
		int K = Integer.parseInt(br.readLine());
		
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine());
			// 정점의 개수
			V = Integer.parseInt(st.nextToken());
			// 간선의 개수
			E = Integer.parseInt(st.nextToken());
			
			
			// 선언
			graph = new ArrayList[V+1];
			color = new int[V+1];
			
			// 생성
			for(int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			
			// 연결
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				graph[v1].add(v2);
				graph[v2].add(v1);
				
			}
			
			if(bfs(1)) {
				sb.append("YES").append("\n");
			}
			
			
		}
		System.out.println(sb);
	}
	
	static boolean bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		// 모든 노드 탐색
		for(int i = 1; i <= V; i++) {
			
			// 시작(root)부터 1로 만들어 준다.
			// 순회를 시작하는 노드를 1로 만들어 줬으니 그 다음 노드는 1이 아닌 다른 수여야 한다.
			if(color[i] == 0) {
//				System.out.println("여기여기 모여라" + " " + i);
				color[i] = 1;
				q.add(i);
			}
		
			while(!q.isEmpty()) {
				
				int pos = q.poll();
				
				for(int next : graph[pos]) {
					
//					color[pos] = 1;
					
                    if(color[next] == color[pos]) {
                    	sb.append("NO").append("\n");
						return false;	
					}
                    
					if(color[next] == 0) {
//						System.out.println("여기로 들어왔나" + " " + next);
						q.add(next);
						
						if(color[pos] == 1) {
							color[next] = -1;
						}else {
							color[next] = 1;
						}
					}
				}
			}
		}
		
		return true;
	}
	
	
}
/*
 * 자유롭게 자기소개를 해주세요(본인이 생각하는 자신은 어떤 사람인가요?)  
 * 
 * 		--> 프로젝트하면서 마찰은 없었는지. 마찰이 있을 경우 어떻게 해결하는지
 * 
 * 
 * 		--> 월 5억 되찾은 사례 --> 금융과 반도체는 산업이 아예 다른데 반도체 회사에 지원한 이유와 다른 회사가 아니라 왜 하이닉스에 지원하였는지
 * 
 *  
 * 		--> 지원한 직무가 무엇인지 설명하기 해당 직무와 관련하여 어떠한 노력을 하였는지(SCM에 대해 공부했다고 하면 좋으려낭?!)
 * 
 * 
 * 삼성이나 다른 반도체 회사와 차별되는 하이닉스의 장점은 무엇이라 생각하는지 
 * 
 * 
 * 저희 하이닉스의 경영철학과 인재상에 대해 알고 있으신가? --> 본인이 생각하기에 부합한가요?
 * 
 * 
 * 앞으로의 하이닉스 발전 방향에 대해 생각한 게 있으면 말씀해 주세요. 
 * 
 * 
 * 마지막 질문 : 만약 입사하였을 경우 하이닉스에 어떤 도움을 줄 수 있는지 말씀해주세요 
 * 
 * 
 */
