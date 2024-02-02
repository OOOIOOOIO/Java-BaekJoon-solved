package softeer.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 회의실예약 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
됨
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());    // 회의실 수
        int M = Integer.parseInt(st.nextToken());    // 회의의 수

        Map<String, int[][]> reservation = new TreeMap<>(); // 정렬됨

        for (int i = 0; i < N; i++) {
            int[][] meetingTime = new int[9][2];

            for (int j = 0; j < 9; j++) {
                meetingTime[j][0] = j;
                meetingTime[j][1] = j + 1;
            }
            reservation.put(br.readLine(), meetingTime);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int[][] curr = reservation.get(name);
            for (int j = start; j < end; j++) {
                curr[j - 9][0] = -1;
                curr[j - 9][1] = -1;
            }
        }

        for (Map.Entry<String, int[][]> entry : reservation.entrySet()) {
            sb.append("Room ").append(entry.getKey()).append(":").append("\n");
            StringBuilder temp = new StringBuilder();

            int[][] curr = entry.getValue();
            int total = 0;
            int start = -1;
            int end = -1;

            for (int i = 0; i < 9; i++) {
                if (curr[i][0] != -1) {// 예약 가능한 시간대인 경우
                    if (start == -1) {// 아직 시작점이 정해지지 않은 경우
                        start = curr[i][0];
                    }
                }
                else { // 예약 불가 시간인 경우
                    if (start != -1) {// 시작점이 정해진 경우 -> end가 와야된다.
                        end = curr[i - 1][1];
                    }
                }

                if (start != -1 && end != -1) { // 시작과 끝이 정해졌을 경우, 0부터 시작이니 9를 더해준다
                    temp.append(start == 0 ? "09" : start + 9).append("-");
                    temp.append(end + 9).append("\n");
                    start = -1; // 초기화
                    end = -1;
                    total++;
                }
            }

            if (start != -1) { // 마지막까지 쭉일 경우
                total++;
                temp.append(start + 9 == 9 ? "09" : start + 9).append("-").append(18).append("\n");
            }

            if (total == 0) { // 다 꽉찼을 경우
                sb.append("Not available").append("\n");
            }
            else {
                sb.append(total).append(" available:").append("\n");
                sb.append(temp);
            }

            sb.append("-----").append("\n");
        }

        sb.setLength(sb.length() - 6); // 마지막 ----- 빼주기

        System.out.println(sb);
    }

}
