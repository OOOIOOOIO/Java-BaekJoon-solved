package problems.test;

import java.time.LocalDate;
import java.time.YearMonth;

public class te {

    public static void main(String[] args) {
        byte[] repeatDays = new byte[32];

        int i = 1;
        for (byte repeatDay : repeatDays) {
            System.out.println("repeatDay = " + repeatDay);
            System.out.println(i++);
        }
    }


}
