package com.java.course.section3.dates;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PracticeDates {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println("##################");

        System.out.println(today.plusYears(1).getDayOfWeek());
        System.out.println("##################");

        LocalTime teaTime = LocalTime.of(17, 30);
        System.out.println(teaTime);
        System.out.println("##################");

        //get duration between two dates
        Duration timeGap = Duration.between(LocalTime.now(), teaTime);
        System.out.println(timeGap);
        System.out.println(timeGap.toMinutes());
        System.out.println(timeGap.toHours());
        System.out.println(timeGap.toMillisPart());

        //Duration when second time is greater than first
        //el resultado es negativo
        System.out.println(Duration.between(LocalTime.now(), LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute() - 2)));
        System.out.println("##################");

        System.out.println(timeGap.toMinutes());

        LocalDateTime tomorrowDateTime = LocalDateTime.of(today.plusDays(1), teaTime);
        System.out.println(tomorrowDateTime);
        System.out.println("##################");

        ZoneId london = ZoneId.of("Europe/London");
        ZoneId katmandu = ZoneId.of("Asia/Katmandu");

        ZonedDateTime londonTime = ZonedDateTime.of(tomorrowDateTime, london);
        System.out.println(londonTime);

        ZonedDateTime katmanduTime = londonTime.withZoneSameInstant(katmandu);
        System.out.println(katmanduTime);
        System.out.println(katmanduTime.getOffset());
        System.out.println("##################");

        String datePattern = "EE', 'd', de 'MMMM yyyy' a las 'HH:mm z";
        System.out.println(datePattern);

        Locale locale = Locale.UK;
        System.out.println(locale);

        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern(datePattern, locale);
        String timeTxt = dateFormater.format(katmanduTime);
        System.out.println(timeTxt);
    }
}
