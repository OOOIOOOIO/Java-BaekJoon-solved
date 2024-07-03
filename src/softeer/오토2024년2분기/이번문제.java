package softeer.오토2024년2분기;

import java.io.*;
import java.util.*;

public class 이번문제 {

    static int N;
    static int[] container;
    static int totalCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        //필요부품 기입
        int[] parts = new int[6]; //필요부품 목록(1~5)
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 5; i++){
            parts[i] = Integer.parseInt(st.nextToken());
        }

        //컨테이너 생성 및 기입
        N = Integer.parseInt(br.readLine());

        container = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 5; i++){
            int cnt = Integer.parseInt(st.nextToken());
            container[i] = cnt;
            totalCnt += cnt;
        }

        int min = Integer.MAX_VALUE;
        // 시작지점
        for(int start = 0; start < N; start++){
            // parts 복사
            int[] partsTemp = parts.clone();
            // totalCnt 복사
            int cnt = totalCnt;

            int res = solve(start, partsTemp, cnt);

            min = Math.min(min, res);
        }

        if(min == -1){
            System.out.println(-1);
        }

    }

    private static int solve(int start, int[] parts, int cnt){
        int endPos = container.length;
        int startPos = start;
        int ans = 0;

        // 시작위치부터 반시계로 돌리기
        while(startPos-- > 0){
            // 필요부품 check
            if(check(parts)){
                return ans;
            }

            ans++; // 확인수 증가

            int part = container[startPos];

            // 남아있다면
            if(parts[part] > 0){
                parts[part]--; // 개수빼기
                cnt--; // 전체개수 빼기
            }
        }

        //만약 0까지 왔으면, 거꾸로 시작점까지 돌리기
        while(endPos > start){
            // 필요부품 check
            if(check(parts)){
                return ans;
            }

            ans++; // 확인수 증가

            int part = container[endPos];

            // 남아있다면
            if(parts[part] > 0){
                parts[part]--; // 개수빼기
                cnt--; // 전체개수 빼기
            }

        }

        //만약 다 돌렸는데 toatlCnt가 남아있다면 -1 return
        return -1;


    }
    private static boolean check(int[] parts){
        if(parts[1] == 0 && parts[2] == 0 && parts[3] == 0 && parts[4] == 0 && parts[5] == 0){

            return true;
        }

        return false;
    }





}









