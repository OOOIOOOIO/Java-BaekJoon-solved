package softeer.HSAT5회;

import java.io.*;
import java.util.*;

public class 성적평가 {
    static class Person{
        int num;
        int score;
        int rank;

        public Person(int num, int score){
            this.num = num;
            this.score = score;
            this.rank = -1;

        }

        public void updateScore(int score){
            this.score = score;
        }

        public void updateRank(int rank){
            this.rank = rank;
        }

    }

    static class TotalScore {
        int num;
        int totalScore;
        int rank;

        public TotalScore(int num){
            this.num = num;
            this.totalScore = 0;
            this.rank = -1;

        }

        public void addTotalScore(int score){
            this.totalScore += score;
        }

        public void updateRank(int rank){
            this.rank = rank;
        }
    }

    static int n;
    static final int MATCH = 3;
    static List<TotalScore> totalList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        n = Integer.parseInt(br.readLine()); //참가자 수

        //초기화
        for(int i = 0; i < n; i++){
            totalList.add(new TotalScore(i));
        }

        for(int k = 0; k < MATCH; k++){ // 경기횟수 : 3
            st = new StringTokenizer(br.readLine());
            List<Person> pList = new ArrayList<>();

            // 사람들, 총점수 저장
            for(int i = 0; i < n; i++){
                int score = Integer.parseInt(st.nextToken());

                pList.add(new Person(i, score));
                totalList.get(i).addTotalScore(score);

            }

            // 각대회마다 점수 desc정렬
            Collections.sort(pList, (o1, o2) -> {
                return o2.score - o1.score;
            });


            getPersonalRank(pList);

            //다시 num순으로 asc정렬
            Collections.sort(pList, (o1, o2) -> {
                return o1.num - o2.num;
            });

            for(int i = 0; i < n; i++){
                sb.append(pList.get(i).rank + " ");
            }
            sb.append("\n");

        }


        // 총점수 desc정렬
        Collections.sort(totalList, (o1, o2) -> {
            return o2.totalScore - o1.totalScore;
        });

        getTotalRank(totalList);

        // 다시 num순으로 asc정렬
        Collections.sort(totalList, (o1, o2) -> {
            return o1.num - o2.num;
        });

        for(int i = 0; i < n; i++){
            sb.append(totalList.get(i).rank + " ");
        }

        System.out.println(sb);

    }

    private static void getPersonalRank(List<Person> pList){
        // 1등
        Person p = pList.get(0);
        int prevScore = p.score; // 이전 등수의 점수
        int prevRank = 1; // 이전 등수
        int sameCnt = 0; // 같은사람의 등수
        p.updateRank(prevRank);

        // 2등부터
        for(int j = 1; j < n; j++){
            Person currP = pList.get(j);

            // 이전 사람의 점수가 더 높다면
            if(prevScore > currP.score){
                prevScore = currP.score;
                prevRank += (sameCnt + 1);
                sameCnt = 0;

                currP.updateRank(prevRank);
            }
            else{ // 점수가 같다면
                sameCnt += 1;

                currP.updateRank(prevRank);
            }


        }

    }


    private static void getTotalRank(List<TotalScore> totalList){
        // 1등
        TotalScore p = totalList.get(0);
        int prevScore = p.totalScore; // 이전 등수의 점수
        int prevRank = 1; // 이전 등수
        int sameCnt = 0; // 같은사람의 등수
        p.updateRank(prevRank);

        // 2등부터
        for(int j = 1; j < n; j++){
            TotalScore currP = totalList.get(j);

            // 이전 사람의 점수가 더 높다면
            if(prevScore > currP.totalScore){
                prevScore = currP.totalScore;
                prevRank += (sameCnt + 1);
                sameCnt = 0;

                currP.updateRank(prevRank);

            }
            else{ // 점수가 같다면
                sameCnt += 1;

                currP.updateRank(prevRank);
            }


        }



    }





}













