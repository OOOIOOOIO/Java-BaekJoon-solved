package problems.test;

import java.time.LocalDate;
import java.time.YearMonth;

public class te {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        LocalDate start = LocalDate.of(2024, 05, 01);
        LocalDate end = LocalDate.of(2024, 07, 31);
        LocalDate comp = LocalDate.of(2024, 06, 01);
        LocalDate after = LocalDate.of(2024, 06, 02);
        LocalDate targetDay = LocalDate.of(2024, 06, 13);
        LocalDate endOfMonth = LocalDate.of(2024, 06, 30);
        LocalDate startOfMonth = LocalDate.of(2024, 06, 01);

        System.out.println("test : " + test(start, end));

        LocalDate localDate = start.plusMonths(1); // 3개월 미만, 마지마막달 찾기
        System.out.println("localDate = " + localDate);

        System.out.println("compate : " + start.compareTo(comp)); // 같으면 0
        System.out.println("equal : " + start.isEqual(comp)); // 같으면 0
        System.out.println("after : " + start.isAfter(after)); // 같으면 0
        System.out.println("before : " + start.isBefore(after)); // 같으면 0

        if((start.isBefore(targetDay) || start.isEqual(targetDay)) && (endOfMonth.isAfter(targetDay) || endOfMonth.isEqual(targetDay))){
            System.out.println("affdsffff");
        }

        if((startOfMonth.isBefore(targetDay) || startOfMonth.isEqual(targetDay)) && (end.isAfter(targetDay) || end.isEqual(targetDay))){
            System.out.println("ftqueygwirhgeotihrnustgbeyrvuf");
        }
        System.out.println();
        isMoreThanOneMonth(start, end);



    }

    private static int test(LocalDate start, LocalDate end) {

        int monthA = start.getYear() * 12 + start.getMonthValue();
        int monthB = end.getYear() * 12 + end.getMonthValue();

        return (monthB - monthA) + 1; // 5/1 ~ 5/31 : 0으로 나옴 +1 해주기
    }
    private static boolean isMoreThanOneMonth(LocalDate start, LocalDate end) {
        int startYear = start.getYear();
        int startMonth = start.getMonthValue();

        int endYear = end.getYear();
        int endMonth = end.getMonthValue();

        YearMonth startYearMonth = YearMonth.of(startYear, startMonth);
        YearMonth endYearMonth = YearMonth.of(endYear, endMonth);

        LocalDate nextMonthFirstDayFromStartDay = startYearMonth.atEndOfMonth().plusDays(1); // 다음달 첫날
        LocalDate beforeMonthLastDayFromEndDay = endYearMonth.atDay(1).minusDays(1); // 이전달 마지막날

        boolean before = nextMonthFirstDayFromStartDay.isBefore(beforeMonthLastDayFromEndDay);

        System.out.println("before = " + before);
        return before;
    }






}
