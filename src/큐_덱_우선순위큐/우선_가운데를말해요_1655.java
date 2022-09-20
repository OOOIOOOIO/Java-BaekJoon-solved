package 큐_덱_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 우선_가운데를말해요_1655 {
	static Queue<Integer> queue = new PriorityQueue<Integer>();
	static Queue<Integer> minHeap = new PriorityQueue<Integer>();
	static Queue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() { // new PriorityQueue<Integer>(Comparator.reverseOrder()); 이거랑 똑같음
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		};
	});
	static LinkedList<Integer> save = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		// 개수
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			
			int ele = Integer.parseInt(br.readLine());
			
			// 무조건 maxHeap에서 뺄 수 있게 번갈아 가면서 넣는다.
			// minHeap으로 들어 갔다는 것은 max가 비어있지 않다는 뜻이다.
			if(minHeap.size() == maxHeap.size()) {
				maxHeap.offer(ele);
				
				// minHeap이 비어있지 않고 min이 더 작다면 min 
				if(!(minHeap.isEmpty()) && (maxHeap.peek() > minHeap.peek())) {
					// 서로 최댓값과 최솟값을 바꿔주면서 구조를 유지한다. 이게 핵심!
					maxHeap.offer(minHeap.poll());
					minHeap.offer(maxHeap.poll());
				}
			}
			else {
				minHeap.offer(ele);
				// 비교
				if((maxHeap.peek() > minHeap.peek())) {
					maxHeap.offer(minHeap.poll());
					minHeap.offer(maxHeap.poll());
				}
			}
			
			// 첫번째 요소와 이후 중간값들
			sb.append(maxHeap.peek()).append("\n");
		}
		
		System.out.println(sb);
	}
	
}

