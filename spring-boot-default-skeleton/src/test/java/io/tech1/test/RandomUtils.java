package io.tech1.test;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings({ "rawtypes", "unchecked" })
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomUtils {
    private static final Random RND = ThreadLocalRandom.current();
    private static final String EMAIL_DOMAIN = "@tech1.io";
    private static final int UNIQUE_VALUE = 1;

    public static <T extends Enum> T randomEnum(Class<?> enumClazz) {
        Object[] values = enumClazz.getEnumConstants();
        return (T) values[RND.nextInt(values.length)];
    }

    public static <T extends Enum> T randomEnumExcept(Class<?> enumClazz, T enumInstance) {
        Object[] values = enumClazz.getEnumConstants();
        Optional<Object> enumOpt = Stream.of(values)
                .filter(item -> !item.equals(enumInstance))
                .findAny();
        if (enumOpt.isPresent()) {
            return (T) enumOpt.get();
        } else {
            throw new IllegalArgumentException("No exchange type. Please check " + enumClazz + " enum");
        }
    }

    public static <T extends Enum> T randomEnumExcept(Class<?> enumClazz, List<T> enumInstances) {
        Object[] values = enumClazz.getEnumConstants();
        Optional<Object> enumOpt = Stream.of(values)
                .filter(item -> !enumInstances.contains(item))
                .findAny();
        if (enumOpt.isPresent()) {
            return (T) enumOpt.get();
        } else {
            throw new IllegalArgumentException("No exchange type. Please check " + enumClazz + " enum");
        }
    }

    public static boolean randomBoolean() {
        return RND.nextBoolean();
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
        return UUID.randomUUID() + EMAIL_DOMAIN;
    }

    public static int unique() {
        return UNIQUE_VALUE;
    }

    public static Integer randomSmallInteger() {
        return RND.nextInt(4) + 1;
    }

    public static Integer randomIntegerTwoDigits() {
        return RND.nextInt(10) + 89;
    }

    public static Integer randomIntegerByBound(int bound) { return RND.nextInt(bound); }

    public static Integer randomInteger() {
        return RND.nextInt();
    }

    public static Integer randomNegativeInteger() {
        return -RND.nextInt();
    }

    public static Long randomLong() {
        return RND.nextLong();
    }

    public static Double randomDouble() {
        return RND.nextDouble();
    }

    public static BigDecimal randomBigDecimal() {
        return BigDecimal.valueOf(randomDouble() * randomIntegerTwoDigits());
    }

    public static BigDecimal randomNegativeBigDecimal() {
        return BigDecimal.valueOf(randomDouble() * -randomIntegerTwoDigits());
    }

    public static BigDecimal uniqueBigDecimal() {
        return BigDecimal.valueOf(unique());
    }

    public static Short randomShort() {
        return (short) RND.nextInt(Short.MAX_VALUE + 1);
    }
}
