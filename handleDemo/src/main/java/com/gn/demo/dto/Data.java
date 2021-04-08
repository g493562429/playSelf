package com.gn.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author gn
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {
            private String animalsYear;
            private String weekday;
            private String lunarYear;
            private String lunar;
            @JsonAlias("year-month")
            private String yearMonth;
            private String date;
            private String suit;
            private String avoid;
            private String holiday;
            private String desc;
        }