package com.example.easybookkeepingsystem.common.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeUtils {

    public static final String KST = "Asia/Seoul";
    public static final ZoneId ZONE_ID_KST = ZoneId.of(KST);
    public static final String PATTERN_DISPLAY_DATETIME = "yyyy-MM-dd HH:mm:ss";

    public static Instant firstTimeOfMonth(ZoneId zoneId, int year, int month) {
        return ZonedDateTime.of(year, month, 1, 0, 0, 0, 0, zoneId).toInstant();
    }

    public static Instant lastTimeOfMonth(ZoneId zoneId, int year, int month) {
        return ZonedDateTime.of(year, month + 1, 1, 0, 0, 0, 0, zoneId).toInstant().minusNanos(1);
    }

}
