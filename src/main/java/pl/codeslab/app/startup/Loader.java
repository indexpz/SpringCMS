package pl.codeslab.app.startup;

import java.util.Set;

public interface Loader {

    Integer getPriority();

    String getEntityName();

    Set<Long> createEntities();
}
