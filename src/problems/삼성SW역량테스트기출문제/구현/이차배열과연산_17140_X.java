package problems.삼성SW역량테스트기출문제.구현;

import java.util.*;
import java.io.*;

public class 이차배열과연산_17140_X {

    static int r, c, k;
    static int[][] map = new int[101][101];
    static int rowSize;
    static int colSize;

    // 람다용 변수
    static final int[] w = new int[]{1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        // 입력
        for(int i = 1; i <= 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <=3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫번째는 무조건 R
        rowSize = 3;
        colSize = 3;
        int cnt = 0;
        int t = 0;

        if(map[r][c] == k){
            System.out.println(cnt);
        }
        else{
            for(t = 0; t < 99; t++){
                //행, 열 검사
                if(rowSize() >= colSize()){ // 비교 및 row, col size 최신화
                    R();
                    cnt++;
                    if(map[r][c] == k){
                        System.out.println(cnt);
                        break;
                    }
                }
                else{
                    C();
                    cnt++;
                    if(map[r][c] == k) {
                        System.out.println(cnt);
                        break;
                    }
                }
            }


        }



        // 확인, 99번

        if(t == 99){
            System.out.println(-1);
        }



    }

    private static void R(){


        for(int i = 1; i <= rowSize; i++){
            Map<Integer, Integer> pair = new HashMap<>(); //<수, 횟수>
            int l = 1;
            w[0] = 1;

            //수 세기
            for(int j = 1; j <= colSize; j++){
                pair.put(map[i][j], pair.getOrDefault(map[i][j], 0) + 1);
            }

            // 한줄 0으로 만들어주기
            for(int m = 1; m <= colSize; m++){
                map[i][m] = 0;
            }

            //정렬하기, 횟수가 작은 순 -> 수가 적은 순(반대로)
            int finalI = i;
            pair.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().thenComparing((o1, o2) -> o1.getKey() - o2.getKey()))
                    .iterator()
                    .forEachRemaining((o1) -> { // 때려박기
                        map[finalI][w[0]++] = o1.getKey();
                        map[finalI][w[0]++] = o1.getValue();

                    });


        }



    }



    private static void C(){
        for(int i = 1; i <= colSize; i++){
            Map<Integer, Integer> pair = new HashMap<>(); //<수, 횟수>
            int l = 1;
            w[0] = 1;

            //수 세기
            for(int j = 1; j <= rowSize; j++){
                pair.put(map[j][i], pair.getOrDefault(map[j][i], 0) + 1);
            }

            // 한줄씩 0으로 만들어주기
            for(int m = 1; m <= rowSize; m++){
                map[m][i] = 0;
            }

            //정렬하기, 횟수가 작은 순 -> 수가 적은 순(반대로)
            int finalI = i;
            pair.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().thenComparing((o1, o2) -> o1.getKey() - o2.getKey()))
                    .iterator()
                    .forEachRemaining((o1) -> { // 때려박기
                        map[w[0]++][finalI] = o1.getKey();
                        map[w[0]++][finalI] = o1.getValue();

                    });


        }

    }

    private static void print(){
        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void clear(){
        for(int i = 1; i <= rowSize; i++){
            for(int j = 1; j <= colSize; j++){
                map[i][j] = 0;
            }
        }
    }

    private static int rowSize(){
        if(rowSize >= 100) return 100;

        int max = 0;

        for(int i = 1; i <= 100; i++){
            int size = 0;

            for(int j = 1; j <= 100; j++){
                if(map[i][j] != 0) size++;
            }

            max = Math.max(max, size);
        }

        rowSize = max;
        return max;
    }


    private static int colSize(){
        if(colSize >= 100) return 100;

        int max = 0;

        for(int i = 1; i <= 100; i++){
            int size = 0;

            for(int j = 1; j <= 100; j++){
                if(map[j][i] != 0) size++;
            }

            max = Math.max(max, size);
        }

        colSize = max;
        return max;
    }


}
