package org.jboss.reproducer.classpath.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/**
 * This is a stand-in for the API class.
 */
public interface TheApi {
    static List<TheApi> findImplementation(ClassLoader cl) {
        ServiceLoader<TheApi> loader = ServiceLoader.load(TheApi.class, cl);
        Iterator<TheApi> iterator = loader.iterator();
        List<TheApi> list = new ArrayList<>();
        for (;;) try {
            if (! iterator.hasNext()) {
                return list;
            }
            TheApi item = iterator.next();
            list.add(item);
        } catch (ServiceConfigurationError | RuntimeException e) {
            e.printStackTrace();
        }
    }
}
