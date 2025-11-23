package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
/**
 * Application controller. Performs the I/O.
 */

public class Controller {

    private final String home = System.getProperty("user.home");
    private final String separator = System.getProperty("file.separator");
    private File fileCurrent = new File(home + separator + "output.txt");

    /**
     * @param file set a new file as current file
     */
    public void setAsCurrentFile(final File file) {
        this.fileCurrent = file;
    }

    /**
     * @return the current file
     */
    public File getFile() {
        return this.fileCurrent;
    }

    /**
     * @return the path of the current file
     */
    public String getFilePath() {
        return this.fileCurrent.getPath();
    }

    /**
     * @param message save a text on current file
     * 
     * @throws IOException if the saving fails
     */
    public void saveOnFile(final String message) throws IOException {
        try (PrintStream ps = new PrintStream(this.fileCurrent, StandardCharsets.UTF_8)) {
            ps.print(message);
        }
    }
}
