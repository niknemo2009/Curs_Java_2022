package user_def_type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class MyDateTest {
    static final LocalDate TODAY = LocalDate.now();
    static MyDate myDate = new MyDate();

    static Stream<Arguments> providerDays() {
        return Stream.of(
                Arguments.of(21, 21),
                Arguments.of(0, myDate.getDayofMonth()),
                Arguments.of(-22, myDate.getDayofMonth())

        );
    }

    @BeforeEach
    void clearDate() {
        myDate = new MyDate();
    }

    @Test
    void checkGetDayofMonth() {
        assertEquals(LocalDate.now().getDayOfMonth(), myDate.getDayofMonth());
        MyDate temp = new MyDate(12, Month.APRIL, 2001);
        assertEquals(LocalDate.of(2001, Month.APRIL, 12).getDayOfMonth(), temp.getDayofMonth());
        temp = new MyDate(112, Month.AUGUST, 2022);
        assertEquals(TODAY.getDayOfMonth(), temp.getDayofMonth());
    }

    @Test
    void checkGetMonth() {
        assertEquals(LocalDate.now().getMonth(), myDate.getMonth());
        MyDate temp = new MyDate(12, Month.APRIL, 2001);
        assertEquals(LocalDate.of(2001, Month.APRIL, 12).getMonth(), temp.getMonth());
        temp = new MyDate(38, Month.AUGUST, 2022);
        assertEquals(TODAY.getMonth(), temp.getMonth());
    }

    @Test
    void checkGetYear() {
        assertEquals(LocalDate.now().getYear(), myDate.getYear());
        MyDate temp = new MyDate(12, Month.APRIL, 2001);
        assertEquals(LocalDate.of(2001, Month.APRIL, 12).getYear(), temp.getYear());
        temp = new MyDate(38, Month.AUGUST, 2022);
        assertEquals(TODAY.getYear(), temp.getYear());
    }

    @ParameterizedTest
    @MethodSource("providerDays")
    void checkSetDay(int newDay, int expextedResult) {
        myDate.setDay(newDay);
        assertEquals(myDate.getDayofMonth(), expextedResult);

    }

    @Test
    void checkSetMonth() {
        myDate.setMonth(Month.AUGUST);
        assertEquals(myDate.getMonth(), Month.AUGUST);
        myDate = new MyDate(31, Month.JANUARY, 2022);
        myDate.setMonth(Month.FEBRUARY);
        assertEquals(myDate.getMonth(), Month.JANUARY);
        myDate.setMonth(null);
        assertEquals(myDate.getMonth(), Month.JANUARY);

    }

    @Test
    void checkSetYear() {
        myDate = new MyDate(12, Month.AUGUST, 2021);
        myDate.setYear(2023);
        assertEquals(myDate.getYear(), 2023);
        myDate = new MyDate(29, Month.FEBRUARY, 2000);
        myDate.setYear(2021);
        assertEquals(myDate.getYear(), 2000);
    }

    @Test
    void checkDctor() {
        assertEquals(myDate.getDayofMonth(), TODAY.getDayOfMonth());
        assertEquals(myDate.getMonth(), TODAY.getMonth());
        assertEquals(myDate.getYear(), TODAY.getYear());
    }

    @Test
    void checkCctor() {
        myDate = new MyDate(12, Month.AUGUST, 2021);
        assertEquals(myDate.getDayofMonth(), 12);
        assertEquals(myDate.getMonth(), Month.AUGUST);
        assertEquals(myDate.getYear(), 2021);
        myDate = new MyDate(12, null, 2021);
        assertEquals(myDate.getDayofMonth(), TODAY.getDayOfMonth());
        assertEquals(myDate.getMonth(), TODAY.getMonth());
        assertEquals(myDate.getYear(), TODAY.getYear());
        myDate = new MyDate(38, Month.AUGUST, 2021);
        assertEquals(myDate.getDayofMonth(), TODAY.getDayOfMonth());
        assertEquals(myDate.getMonth(), TODAY.getMonth());
        assertEquals(myDate.getYear(), TODAY.getYear());

    }
}