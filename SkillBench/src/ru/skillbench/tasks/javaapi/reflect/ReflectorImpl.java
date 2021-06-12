package ru.skillbench.tasks.javaapi.reflect;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReflectorImpl implements Reflector {

    private Class<?> clazz;

    @Override
    public void setClass(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Stream<String> getMethodNames(Class<?>... paramTypes) {
        if (clazz == null) {
            throw new NullPointerException();
        }
        ArrayList<String> list = new ArrayList<>();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            Class<?>[] params = method.getParameterTypes();
            if (Arrays.equals(params, paramTypes)) {
                list.add(method.getName());
            }
        }
        return list.stream();
    }

    @Override
    public Stream<Field> getAllDeclaredFields() {
        if (clazz == null) {
            throw new NullPointerException();
        }
        Field[] fileds = clazz.getDeclaredFields();
        return Arrays.stream(fileds).filter(field -> !Modifier.isStatic(field.getModifiers()));
    }

    @Override
    public Object getFieldValue(Object target, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz == null ? target.getClass().getDeclaredField(fieldName) : clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(target);
    }

    @Override
    public Object getMethodResult(Object constructorParam, String methodName, Object... methodParams) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj = constructorParam == null ? clazz.newInstance() : clazz.getConstructor(constructorParam.getClass()).newInstance(constructorParam);
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                method.setAccessible(true);

                try {
                    return method.invoke(obj, methodParams);
                }
                catch (InvocationTargetException e) {
                    if (e.getTargetException() instanceof NumberFormatException) {
                        throw new NumberFormatException();
                    }
                    throw e;
                }
            }
        }
        return null;
    }
}