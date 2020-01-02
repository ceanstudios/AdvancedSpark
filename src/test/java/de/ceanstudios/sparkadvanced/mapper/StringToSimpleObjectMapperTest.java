package de.ceanstudios.sparkadvanced.mapper;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringToSimpleObjectMapperTest {

    @Test
    public void testIfMapLongCorrect() {
        StringToSimpleObjectMapper stringToSimpleObjectMapper = new StringToSimpleObjectMapper();

        final long result = (long) stringToSimpleObjectMapper.map(Long.class, "100");

        assertEquals(100L, result);
    }

    @Test
    public void testIfMapIntegerCorrect() {
        StringToSimpleObjectMapper stringToSimpleObjectMapper = new StringToSimpleObjectMapper();

        final int result = (int) stringToSimpleObjectMapper.map(Integer.class, "1");

        assertEquals(1, result);
    }

    @Test
    public void testIfMapShortCorrect() {
        StringToSimpleObjectMapper stringToSimpleObjectMapper = new StringToSimpleObjectMapper();

        final short result = (short) stringToSimpleObjectMapper.map(Short.class, "1");

        assertEquals(1, result);
    }

    @Test
    public void testIfMapByteCorrect() {
        StringToSimpleObjectMapper stringToSimpleObjectMapper = new StringToSimpleObjectMapper();

        final byte result = (byte) stringToSimpleObjectMapper.map(Byte.class, "1");

        assertEquals(1, result);
    }

    @Test
    public void testIfMapDoubleCorrect() {
        StringToSimpleObjectMapper stringToSimpleObjectMapper = new StringToSimpleObjectMapper();

        final double result = (double) stringToSimpleObjectMapper.map(Double.class, "1.5");

        assertEquals(1.5, result, 0.5);
    }

    @Test
    public void testIfMapFloatCorrect() {
        StringToSimpleObjectMapper stringToSimpleObjectMapper = new StringToSimpleObjectMapper();

        final float result = (float) stringToSimpleObjectMapper.map(Float.class, "1.5");

        assertEquals(1.5F, result, 0.5F);
    }

    @Test
    public void testIfMapStringCorrect() {
        StringToSimpleObjectMapper stringToSimpleObjectMapper = new StringToSimpleObjectMapper();

        final String result = (String) stringToSimpleObjectMapper.map(String.class, "Test");

        assertEquals("Test", result);
    }

    @Test(expected = NumberFormatException.class)
    public void testIfMapIntegerFailed() {
        StringToSimpleObjectMapper stringToSimpleObjectMapper = new StringToSimpleObjectMapper();

        stringToSimpleObjectMapper.map(Integer.class, "Test");
    }

}