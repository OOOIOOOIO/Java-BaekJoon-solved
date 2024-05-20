package problems.category.위상정렬;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ETTE {

    public static void main(String[] args) {


        LocalDate parse = LocalDate.parse("2024-05-15");
        LocalDate start = LocalDate.parse("2024-05-01"); //수요일(3)
        LocalDate end = LocalDate.parse("2024-07-01"); // 목요일(4)

//        parse.isAfter() && parse.isBefore()


        LocalDate localDate = parse.minusDays(LocalDate.now().getDayOfWeek().getValue() + 1); //월요일 구하기
        System.out.println("localDate = " + localDate);

        System.out.println(ChronoUnit.MONTHS.between(start, end));

        System.out.println("month : " + monthValue(start, end));
        System.out.println(start.plusDays(31));

        int totalDayCnt = (int) ChronoUnit.DAYS.between(start, end);

        System.out.println("원래 : " + totalDayCnt); // 15
        LocalDate plusDays = start.plusDays((7 - start.getDayOfWeek().getValue()) + 1 ); // 일요일 나옴 / +1 해주면 다음주 월요일
        LocalDate minusDays = end.minusDays(end.getDayOfWeek().getValue());// 그 전주 일요일 나옴

        System.out.println("정제 후 : " + ChronoUnit.DAYS.between(plusDays, minusDays));
        System.out.println("plusDays = " + plusDays);
        System.out.println("minusDays = " + minusDays);


    }

    private static int monthValue(LocalDate start, LocalDate end) {

        int monthA = start.getYear() * 12 + start.getMonthValue();
        int monthB = end.getYear() * 12 + end.getMonthValue();

        return monthB - monthA;
    }

    private static int getRestDayCnt(LocalDate start, LocalDate end){
        LocalDate plusDays = start.plusDays((7 - start.getDayOfWeek().getValue()) + 1 ); // 일요일 나옴 / +1 해주면 다음주 월요일
        LocalDate minusDays = end.minusDays(end.getDayOfWeek().getValue());// 그 전주 일요일 나옴

        return (int)ChronoUnit.DAYS.between(plusDays, minusDays) / 6; // 6으로 나눠야 1주
    }
}
