package org.jboss.reproducer.classpath.main;

import java.util.List;

import org.jboss.reproducer.classpath.api.TheApi;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        List<TheApi> list = TheApi.findImplementation(Main.class.getClassLoader());
        for (TheApi theApi : list) {
            System.out.printf("Found %s%n", theApi);
        }
    }
}
