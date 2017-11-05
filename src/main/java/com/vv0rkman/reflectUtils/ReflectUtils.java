package com.vv0rkman.reflectUtils;

import com.vv0rkman.fillers.Filler;
import com.vv0rkman.fillers.FillerA;
import com.vv0rkman.sorters.Sort;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReflectUtils {
    private final static int DEFAULT_SIZE = 50;
    private final static int DEFAULT_FILLER = 0;

    public static Method[] getFillers() {
        Method[] methods = MethodUtils.getMethodsWithAnnotation(Filler.class, FillerA.class);
        return methods;
    }

    public static int getCountOfFillers(){
        return getFillers().length;
    }

    public static String getFillerName(int i){
        return getFiller(i).getName();
    }

    public static Method getFiller(int i) {
        Method[] methods = getFillers();
        if (i <= methods.length) {
            return methods[i];
        } else {
            System.out.println("ID is wrong. Returned default filler. Name: "+methods[DEFAULT_FILLER].toString());
            return methods[DEFAULT_FILLER];
        }
    }

    public static int[] invokeFiller(int i, int size) {
        if (size <= 0) size = DEFAULT_SIZE;
        int[] array = new int[DEFAULT_SIZE];
        try {
            array = (int[]) MethodUtils.invokeStaticMethod(Filler.class, getFiller(i).getName(), size);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static List<Sort> getSorters() {
        List<Sort> sorters = new ArrayList<>();
        Reflections reflections = new Reflections("com.vv0rkman.sorters");
        Set<Class<? extends Sort>> subClasses = reflections.getSubTypesOf(Sort.class);

        for (Class<? extends Sort> subClass : subClasses) {
            if (!Modifier.isAbstract(subClass.getModifiers())) {
                try {
                    final Sort sorter = subClass.newInstance();
                    sorters.add(sorter);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        return sorters;
    }

    public static int getCountOfSorters(){
        return getSorters().size();
    }
}
