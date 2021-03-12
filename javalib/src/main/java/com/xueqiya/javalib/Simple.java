package com.xueqiya.javalib;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Simple {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("com.xueqiya.javalib.Student");
            Object object = c.newInstance();
            Method method = c.getDeclaredMethod("getName");
            String getName = (String) method.invoke(object);
            System.out.println("getName:" + getName);

            Field field = c.getDeclaredField("name");
            field.setAccessible(true);
            field.set(object, "李四");
            String name = (String) field.get(object);
            System.out.println("name:" + name);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}