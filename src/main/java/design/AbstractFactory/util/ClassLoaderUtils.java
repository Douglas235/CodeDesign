package design.AbstractFactory.util;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 根据传入的参数数组args，获取参数的类型数组，用于后续的反射调用。
 * 通过判断参数的实际类型，可以将一些特定类型的参数统一转换为相应的父类型（如List、Map等），
 * 以便进行通用处理
 */
public class ClassLoaderUtils {

    public static Class<?>[] getClazzByArgs(Object[] args) {
        Class<?>[] parameterTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ArrayList) {
                parameterTypes[i] = List.class;
                continue;
            }
            if (args[i] instanceof LinkedList) {
                parameterTypes[i] = List.class;
                continue;
            }
            if (args[i] instanceof HashMap) {
                parameterTypes[i] = Map.class;
                continue;
            }
            if (args[i] instanceof Long){
                parameterTypes[i] = long.class;
                continue;
            }
            if (args[i] instanceof Double){
                parameterTypes[i] = double.class;
                continue;
            }
            if (args[i] instanceof TimeUnit){
                parameterTypes[i] = TimeUnit.class;
                continue;
            }
            parameterTypes[i] = args[i].getClass();
        }
        return parameterTypes;
    }

}

