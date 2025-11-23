package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * @param nextStringToPrint set a new string as nextString
     */
    void setNextString(String nextStringToPrint);

    /**
     * @return next String to print
     */
    String getNextString();

    /**
     * @return the history of printed strings
     */
    List<String> getHistoryPrint();

    /**
     *
     */
    void printCurrentString();
}
