package de.ceanstudios.sparkadvanced.mapper;

public class StringToSimpleObjectMapper {

    public Object map (Class<?> clazz, String parameter) {

        if (clazz == Long.class || clazz == long.class) {
            return Long.parseLong(parameter);
        } else if (clazz == Integer.class || clazz == int.class) {
            return Integer.parseInt(parameter);
        } else if (clazz == Short.class || clazz == short.class) {
            return Short.parseShort(parameter);
        } else if (clazz == Byte.class || clazz == byte.class) {
            return Byte.parseByte(parameter);
        } else if (clazz == Double.class || clazz == double.class) {
            return Double.parseDouble(parameter);
        } else if (clazz == Float.class || clazz == float.class) {
            return Float.parseFloat(parameter);
        }

        return parameter;
    }

}
