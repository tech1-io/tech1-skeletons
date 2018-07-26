package com.forcelate.test;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings({ "rawtypes", "unchecked" })
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomUtils {
    private static Random rnd = ThreadLocalRandom.current();

    private static final String FREEMARKER_MAP_KEY = "randomKey";
    private static final String FREEMARKER_MAP_VALUE = "randomValue";
    private static final String EMAIL_DOMAIN = "@jdv.com";
    private static final int UNIQUE_VALUE = 1;

    public static <T extends Enum> T randomEnum(Class<?> enumClazz) {
        Object[] values = enumClazz.getEnumConstants();
        return (T) values[rnd.nextInt(values.length)];
    }

    public static Map<String, Object> randomFreemarkerMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(FREEMARKER_MAP_KEY, FREEMARKER_MAP_VALUE);
        return map;
    }

    public static boolean randomBoolean() {
        return rnd.nextBoolean();
    }

    public static String randomString() {
        return UUID.randomUUID().toString();
    }

    public static List<String> randomListOfStrings(int size) {
        return IntStream.range(0, size)
                .mapToObj(position -> randomString())
                .collect(Collectors.toList());
    }

    public static String[] randomArrayOfStrings(int size) {
        return IntStream.range(0, size)
                .mapToObj(position -> randomString())
                .toArray(String[]::new);
    }

    public static String randomEmail() {
        return UUID.randomUUID().toString() + EMAIL_DOMAIN;
    }

    public static int randomUnique() {
        return UNIQUE_VALUE;
    }

    public static Integer randomSmallInteger() {
        return rnd.nextInt(4) + 1;
    }

    public static Integer randomIntegerByBound(int bound) { return rnd.nextInt(bound); }

    public static Integer randomInteger() {
        return rnd.nextInt();
    }

    public static Long randomLong() {
        return rnd.nextLong();
    }

    public static Double randomDouble() {
        return rnd.nextDouble();
    }

    public static BigDecimal uniquePositiveBigDecimal() {
        return BigDecimal.valueOf(randomUnique());
    }

    public static Short randomShort() {
        return (short) rnd.nextInt(Short.MAX_VALUE + 1);
    }
}
