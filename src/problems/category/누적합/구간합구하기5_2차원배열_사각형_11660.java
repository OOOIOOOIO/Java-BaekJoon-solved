package problems.category.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author polit
 *
 * 2차원 배열 구간합 구하기는 신기하네
 * 정사각형으로 생각해야된다.
 * ex)2,2 ~ 3,3
 * ㅇ ㅇ ㅇ
 * ㅇ ㅁ ㅁ
 * ㅇ ㅁ ㅁ
 * 
 * ㅇ ㅇ ㅇ
 * ㅇ ㅁ ㅁ
 * ㅁ ㅁ ㅁ 이게 아니다..
 * 
 */
public class 구간합구하기5_2차원배열_사각형_11660 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int num = Integer.parseInt(input[1]);

        
        int[][] map = new int[N+1][N+1];
        int[][] sumArr = new int[N+1][N+1];

        // 사각형 넓이 구하기
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(i == 1 && j == 1) {// 1행 1열
                    sumArr[i][j] += map[i][j];
                }
                else if(i == 1) // 1행, 가로
                    sumArr[i][j] = sumArr[i][j-1] + map[i][j];
                else if(j == 1) // 1열, 세로
                    sumArr[i][j] = sumArr[i-1][j] + map[i][j];
                else // 직사각형, 정사각형
                    sumArr[i][j] = sumArr[i][j-1] + sumArr[i-1][j] - sumArr[i-1][j-1] + map[i][j];
            }
        }

        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()); // 행
            int x1 = Integer.parseInt(st.nextToken()); // 열
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int sum = sumArr[y2][x2]; // 맨 가장자리 값(다 더한 값)
            
            if(y1 == 1 && x1 == 1); // 처음부터 끝까지
            else if(x1 == 1) // 열이 1열일 경우
                sum -= sumArr[y1-1][x2]; // 가로 빼주기
            else if(y1 == 1) // 행이 1행일 경우
                sum -= sumArr[y2][x1-1]; // 세로 빼주기
            else{
                sum -= sumArr[y2][x1-1] + sumArr[y1-1][x2]; // 여백 세로, 가로 빼주기
                sum += sumArr[y1-1][x1-1]; // 중복 값 더해주기
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
        
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= N; j++) {
        		System.out.print(sumArr[i][j] + " ");
        	}
        	System.out.println();
        }
    }
}
