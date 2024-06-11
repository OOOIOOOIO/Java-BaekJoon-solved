package problems.삼성SW역량테스트기출문제;

import java.util.*;
import java.io.*;
import java.util.stream.*;


public class 시험감독_13458{

    static int N;
    static ArrayList<Integer> studentList = new ArrayList<>();
    static int B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 시험장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){

            int A = Integer.parseInt(st.nextToken()); // 한 반의 응시자 수
            studentList.add(A);
        }


        st = new StringTokenizer(br.readLine());

        B = Integer.parseInt(st.nextToken()); // 총감독 관리 학생 수
        C = Integer.parseInt(st.nextToken()); // 부감독 관리 학생 수

        long sum = 0;
        for(int i = 0; i < studentList.size(); i++){
            // 학생수
            int studentCnt = studentList.get(i);
            int restCnt = 0;

            // 학생수가 총감독관리수 보다 작거나 같을 경우
            if(studentCnt <= B){
                sum += 1; //총감
            } // " 클 경우
            else{
                sum += 1; //총감
                restCnt = (studentCnt - B);

                // 나머지가 0인 경우
                if(restCnt % C == 0){
                    sum += (int)(restCnt / C);
                }
                else{
                    sum += (int)(restCnt / C) + 1;
                }
            }
        }

        System.out.println(sum);

    }
}






















