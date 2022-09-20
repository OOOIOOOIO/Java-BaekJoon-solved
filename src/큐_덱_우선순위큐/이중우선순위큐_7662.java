package 큐_덱_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


//		힙(우선순위 큐) 삽입은 nlogn, 삭제는 n (다시 정렬되는 것 까지 해서)
//		treeMap은
//		Sift Up(삽입)의 시간복잡도는 주어진 노드부터 root Node 까지의 높이 로 볼 수 있으며
//		Sift Down(삭제)의 시간복잡도는 해당 노드부터 leaf Node 까지의 높이입니다.
//		treeMap은 삽입 및 삭제가 logn(다시 정렬되는 것 까지 해서) 이진 redblack tree 구조

public class 이중우선순위큐_7662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		TreeMap<Integer, Integer> map = new TreeMap<>();
		
	
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			
			while(k-- > 0) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(str.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				}
				else {
					if(map.isEmpty()) {
						continue;
					}
					else {
						if(num == 1) {
							int temp = map.lastKey();
							if(map.get(temp) == 1) {
								map.remove(temp);
							}
							else {
								map.put(temp, map.get(temp)-1); // 1보다 클 경우 중복 수이다.
							}
						}
						else {
							int maxKey = map.firstKey();
                            if(map.get(maxKey) == 1) {
                                map.remove(maxKey);
                            }else {
                                map.put(maxKey, map.get(maxKey) - 1);
                            }
						}
					}
				}
				
			}
				
			
			if(map.isEmpty()) {
				sb.append("EMPTY\n");
			}
			else {
				sb.append(map.lastKey() + " " + map.firstKey()+ "\n");
			}
		}
		
		System.out.println(sb.toString());
		
		
	}
}
