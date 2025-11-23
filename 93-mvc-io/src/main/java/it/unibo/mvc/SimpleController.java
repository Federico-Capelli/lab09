package it.unibo.mvc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 */
public final class SimpleController implements Controller {

    private final List<String> stringHistory = new LinkedList<>();
    private String nextString;

    @Override
    public void setNextString(final String nextString) {
        if (nextString == null) {
            throw new IllegalArgumentException("Next String cannot be null");
        }
        this.nextString = nextString;
    }

    @Override
    public String getNextString() {
       return this.nextString;
    }

    @Override
    public List<String> getHistoryPrint() {
       return Collections.unmodifiableList(stringHistory);
    }

    @Override
    public void printCurrentString() {
        if (this.nextString == null) {
            throw new IllegalStateException("Current String is unset");
        }
        System.out.println(this.nextString); //NOPMD: allowed
        stringHistory.add(nextString);
    }
}
