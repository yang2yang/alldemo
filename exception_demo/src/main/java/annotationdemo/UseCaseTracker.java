package annotationdemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * *  author:jack 2016年12月2016/12/18日
 */
public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class<?> cl) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        for (Method m : cl.getDeclaredMethods()) {
            m.invoke(cl.newInstance());
        }

        for (Method m : cl.getDeclaredMethods()) {
            System.out.println("When calling getDeclaredMethods function = " + m.getName());
            UseCase uc = m.getAnnotation(UseCase.class);

            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }

        for (Method m : cl.getMethods()) {
            System.out.println("When calling getMethods function = " + m.getName());
        }

        for (int i : useCases) {
            System.out.println("Warning:Missing use case-" + i);
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
