package com.gn.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

/**
 * @Auther: gn
 * @Date: 2020-5-25 19:32
 * @Description:
 */
public class QuickSortController {

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
//        c.add(Calendar.MONTH, 0);
        String format2 = format.format(c.getTime());
        System.out.println(format2);
        c.set(Calendar.DAY_OF_MONTH, 1);
        String first = format.format(c.getTime());
        System.out.println("------>:" + first);

        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.DAY_OF_MONTH,instance.getActualMaximum(Calendar.DAY_OF_MONTH));
        String format1 = format.format(instance.getTime());
        System.out.println(format1);


        LocalDate now = LocalDate.now();
        LocalDate of = LocalDate.of(now.getYear(), now.getMonth(), 1);
        LocalDate with = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(of);
        System.out.println(with);
    }
}
