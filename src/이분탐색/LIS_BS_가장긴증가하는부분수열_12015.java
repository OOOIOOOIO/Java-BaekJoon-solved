package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/*
 * 	LIS(Longest Increasing Subsequence)
 * 최장 증가 부분 수열이란 주어진 수열에서 오름차순으로 정렬된 가장 긴 부분 수열을 찾는 문제이다.
 * 부분 수열이기 때문에 연속적이거나 유일할 필요는 없다.
 * (부분 수열을 쉽게 생각해보자면 최소값이 있는 위치부터 앞만 보고 찾으면 된다)
 *
 * 
 * 	풀이 방법은
 * - Dynamic Programming
 * - Binary Search
 * 
 * 
 *   Binary Search
 * 수열을 정리할 배열 , list, ... 등 테이블을 선언
 * 정리할 테이블에 0을 미리 삽입해하여첫 요소를 비교할 준비를 한다.
 * 기존 수열의 요소를 하나씩 테이블의 마지막 값과 비교하여 수열의 값이 크다면 리스트에 삽입,
 * 작다면 이진탐색을 통해 위치를 구한뒤 수정한다. 
 *  
 */

// Binary Search
public class LIS_BS_가장긴증가하는부분수열_12015 {
	    public static void main(String[] args) throws IOException {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        int[] arr = new int[N];
	        
	        // 수열을 정리할 list
	        List<Integer> list = new ArrayList<>();
	        
	        // 첫 요소부터 비교해야 하기 때문에 미리 0을 삽입
	        list.add(0);

	        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

	        for(int i = 0 ; i < N; i++) {
	        	// 요소를 하나씩 원배열에 넣으면서 비교
	            int value = arr[i] = Integer.parseInt(st.nextToken());
	            
	            // list의 마지막 요소와 원배열 i번째 요소 비교
	            // i번쨰가 더 크다면 그대로 list에 삽입(오름차순)
	            if(value > list.get(list.size() - 1)) {
	            	list.add(value);
	            }
	            // 작다면 Binary Search로 넣을 자리를 찾는다.
	            else{
	                int low = 0;
	                int high = list.size() - 1;

	                while(low < high){
	                	// shift 연산자 	
	                	// >> == /		| x << n = x * n제곱(n이 1일 경우 2, 2일 경우 4, 3일경우 8, ...가 된다)
	                	// << == *		| x >> n = x / n제곱(n이 1일 경우 2, 2일 경우 4, 3일경우 8, ...가 된다)
	                    int mid = (low + high) >> 1;
//	                	int mid = (low + high) / 2;
	                
	                    if(list.get(mid) >= value){
	                        high = mid;
	                    }else{
	                        low = mid + 1;
	                    }
	                }
	                // set(index, value) : 값 수정
	                list.set(high, value);
	            }
	        }
	        System.out.println(list.size() - 1);
	    }

	}
