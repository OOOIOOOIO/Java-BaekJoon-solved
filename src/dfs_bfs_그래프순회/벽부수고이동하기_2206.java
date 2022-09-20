package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206 {
	
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
    private static class Node {
    	private int y;
        private int x;
        private int count;
        private int wall; //벽을 부시면서 왔는지 아닌지. 0이면 아니고 1이면 벽을 부시면서 왔다는 것을 의미한다.
 
        public Node(int y, int x, int count, int wall) {
        	this.y = y;
            this.x = x;
            this.count = count;
            this.wall = wall;
        }
    }
	
   private static int bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(y, x, 1, 0)); // cnt 1로 시작
        
        visited[y][x][0] = true; //0은 벽을 부시지 않고 방문한 노드의 방문 여부
        visited[y][x][1] = true; //1은 벽을 부시면서 방문한 노드의 방문 여부
 
        while (!q.isEmpty()) {
            Node current = q.poll();
            
            // 종료
            if (current.y == N - 1 && current.x == M - 1) {
            	return current.count;
            }
 
            // 4방향 탐색하면서 일단 벽이 있다면 벽을 다 부수고 다음 칸이 벽이 아니라면 쭉 가다 다시 벽이 나오면 이제 -1 리턴
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
 
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                	//벽이 아닐 때
                    if(map[ny][nx] == 0) { 
                    	//
                        if (visited[ny][nx][current.wall] == false) { //현재까지 온 방법(벽을 부쉈는지 아닌지)으로 방문한 적이 없다면 방문한다.
                            q.add(new Node(ny, nx, current.count + 1, current.wall));
                            visited[ny][nx][current.wall] = true;
                        }
                    }    
                  //벽일때
                    else if (map[ny][nx] == 1) { 
                        if (current.wall == 0 && visited[ny][nx][1] == false) { //현재까지 벽을 부순적이 없고, 벽을 부숴서 방문한 적이 없다면 방문한다.
                            q.add(new Node(ny, nx, current.count + 1, 1));
                            visited[ny][nx][1] = true;
                        }
                    }
                }
            }
        }
        
        // 도달하지 못할 경우 
        return -1;
    }
   
   
   
   							// bfs는 맞는데 bf2는 틀림. 왜 틀린지 모르겠다 쓰발
   
   
   
   private static int bfs2(int y, int x) {
	   Queue<int[]> q = new LinkedList<>();
	   
	   q.add(new int[] {y, x, 0}); // 0은 벽을 부수었는지. 1== 부숨
	   
	   visited[y][x][0] = true; //0은 벽을 부시지 않고 방문한 노드의 방문 여부
	   visited[y][x][1] = true; //1은 벽을 부시면서 방문한 노드의 방문 여부
	   
	   while (!q.isEmpty()) {
		   int[] current = q.poll();
		   
		   // 종료
		   if (current[0] == N - 1 && current[1] == M - 1) {
			   return map[N-1][M-1] + 1;
		   }
		   
		   // 4방향 탐색하면서 일단 벽이 있다면 벽을 다 부수고 다음 칸이 벽이 아니라면 쭉 가다 다시 벽이 나오면 이제 -1 리턴
		   for (int i = 0; i < 4; i++) {
			   int ny = current[0] + dy[i];
			   int nx = current[1] + dx[i];
			   int wall = current[2];
					   
			   if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
				   //벽이 아닐 때
				   if(map[ny][nx] == 0) { 
					   //
					   if (!(visited[ny][nx][0])) { //현재까지 온 방법(벽을 부쉈는지 아닌지)으로 방문한 적이 없다면 방문한다.
						   q.add(new int[] {ny, nx, wall});
						   visited[ny][nx][0] = true;
						   map[ny][nx] = map[current[0]][current[1]] + 1;
					   }
				   }    
				   //벽일때
				   else if (map[ny][nx] == 1) { 
					   if (wall == 0 && !(visited[ny][nx][1])) { //현재까지 벽을 부순적이 없고, 벽을 부숴서 방문한 적이 없다면 방문한다.
						   q.add(new int[] {ny, nx, wall+1});
						   visited[ny][nx][1] = true;
						   map[ny][nx] = map[current[0]][current[1]] + 1;
					   }
				   }
			   }
		   }
	   }
	   
	   // 도달하지 못할 경우 
	   return -1;
   }
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		// 세로(행)
		N = Integer.parseInt(st.nextToken());
		// 가로(열)
		M = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		
		
		System.out.println(bfs(0,0));
//		System.out.println(bfs2(0,0));
		
//		System.out.println();
//		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		
		
	}
}
