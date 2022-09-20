package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 중복된 숫자 X,
 오름차순
 숫자가 초기화되는 조건은 N에 도달했을 때, 자리수 M이 되면 끝
	
	예를 들어 N = 4, M = 3 이라면
	_ _ _ 
	1 2 3  <--자리수
	
	dfs(0) --> 1 fix dfs(1)
	 						--> 2 fix dfs(2)
	 			 							--> 3번째 자리수에선 for문을 돌며  |1fix | 2fix | 3번쨰 자리수에서 dfs(3 == M)이 되어 바로바로 수열이 저장된다.
	 			 							     이후 3번째 자리수가 다 돌게 되면 2번째 자리수가 1이 올라가고 다시 3번쨰 자리수가 돌고 2번째 자리수도 만찬가지로 다 돌면 다시 1번째 자리수가 증가하게 되며 
	 			 							     이  과정을 반복한다. 핵심은 visited[i] = false인데 이 과정을 통해 자리수의 값이 변할 수 있는 것이다.
	
 */
public class N과M_1_15649 {
	static boolean[] visited;
	static int[] seq;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int depth) {

		// 재귀의 깊이가 M과 같아지면 탐색과정에서 탐색을 끝내고 담았던 배열을 출력
		if(depth == M) {
			for(int val : seq) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// for문을 돌면서  arr을 채워준다 
		for(int i = 0; i < N; i++) {
			// 만약 해당 노드(값)을 방문하지 않았다면
			if(!(visited[i])) {
				visited[i] = true;	// 해당 노드를 방문 상태로 변경
				seq[depth] = i + 1; // 해당 깊이를 index로 하여 i+1 값 저장
				dfs(depth + 1); // 다음 자식 노드 방문을 위해 depth를 1 증가시키면서 재귀 호출
				
				// i  = ?에 대한 재귀를 한바퀴 돌고 오면 자식 노드 방문이 끝나고 돌아오면 방문한 노드를 방문하지 않은 상태로 변경
				visited[i] = false;
			}
		}
		
	
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 4
		M = Integer.parseInt(st.nextToken());// 3
		
		// 수열의 수
		seq = new int[M];
		visited = new boolean[N];
		
		dfs(0);
		System.out.println(sb);
	}
}	







