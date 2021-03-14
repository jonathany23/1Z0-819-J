package com.java.course.section3.dates;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationFormat {

    public static void main(String[] args) {
        String teaTxt = "Tea";
        String priceTxt = "$1.73";
        String rateTxt = "$6.5";
        String timeTxt = "Fri, 19 oj June 2020 at 22:15 NPT";
        String datePattern = "EE', 'd', de 'MMMM yyyy' a las 'HH:mm z";

        ZoneId london = ZoneId.of("Europe/London");
        ZoneId katmandu = ZoneId.of("Asia/Katmandu");
        LocalDate today = LocalDate.now();
        LocalTime teaTime = LocalTime.of(17, 30);
        LocalDateTime tomorrowDateTime = LocalDateTime.of(today.plusDays(1), teaTime);
        ZonedDateTime londonTime = ZonedDateTime.of(tomorrowDateTime, london);
        ZonedDateTime katmanduTime = londonTime.withZoneSameInstant(katmandu);

        Locale locale = Locale.UK;
        ResourceBundle msg = ResourceBundle.getBundle("messages", locale);

        String offerPattern = msg.getString("offer");
        System.out.println(offerPattern);

        //MessageFormat.format(offerPattern, teaTxt, priceTxt, rateTxt, timeTxt);
        System.out.println(MessageFormat.format(offerPattern, teaTxt, priceTxt, rateTxt, timeTxt));

        locale = new Locale("ru", "RU");
        msg = ResourceBundle.getBundle("messages", locale);
        offerPattern = msg.getString("offer");
        datePattern = msg.getString("dateFormat");

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        NumberFormat percentFormat = NumberFormat.getPercentInstance(locale);
        percentFormat.setMaximumFractionDigits(2);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(datePattern, locale);

        double rate = 0.2;
        double price = 1.73;
        teaTxt = "prod";
        priceTxt = currencyFormat.format(price);
        rateTxt = percentFormat.format(rate);
        timeTxt = dateFormat.format(katmanduTime);

        System.out.println(MessageFormat.format(offerPattern,teaTxt,priceTxt, rateTxt, timeTxt));
    }
}
