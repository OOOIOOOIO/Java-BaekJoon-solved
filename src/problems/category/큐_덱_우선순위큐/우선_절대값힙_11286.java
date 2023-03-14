package problems.category.큐_덱_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 우선_절대값힙_11286 {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * 
		 *  PriorityQueue는 오름차순을 기준으로 쌓이기 때문에 요소가 추가될 때마다 정렬을 수행한다.
		 * 내부적으로 Comparator를 수행하기 때문에 본인이 원하는 Category.정렬 방식을 설정할 수 있다.
		 * 
		 * Heap 구조는 항상 부모가 자식보다 크던지, 항상 자식이 부모보다 작은 자료구조이다.
		 */
		
		 
	    /*
	   
	    Integer 클래스의 compare 메소드
	    
		public static int compare(int x, int y) {
	        return (x < y) ? -1 : ((x == y) ? 0 : 1);
	    }
	    */
		Queue<Integer> queue = new PriorityQueue<Integer>((a1, a2) -> a1 == a2 ? Integer.compare(a1, a2) : Integer.compare(a1, a2));
		
		
		Queue<Integer> quq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// comparator는  항상 o1이 기준이다. / comparable은 this(자기자신)이 기준이다.
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1 < o2 ? -1 : 1;
				}
				
				// o1이 클 경우 return9 양수 : 내림차순  / o1이 작을 경우 return 음수 : 오름차순
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		
//		Queue<Integer> quqd = new LinkedList<Integer>(
//		ArrayList<Integer> aa = new ArrayList<Integer>(		
		StringBuilder sb = new StringBuilder();
		
		//연산의 개수
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			// 정수들
			int X = Integer.parseInt(br.readLine());
			
			// poll
			if(X == 0) {
				if(quq.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(quq.poll()).append("\n");
				}
			}
			// offer
			else {
				quq.offer(X);
			}
		}
		
		
		System.out.println(sb);
	}
}
