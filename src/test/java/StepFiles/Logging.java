package StepFiles;

import static StepFiles.Hooks.scenario;

public class Logging {
    public static void log(String args) {
        scenario.write(args + "\n");
    }


}
