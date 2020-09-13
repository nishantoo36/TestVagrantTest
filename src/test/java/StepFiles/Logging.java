package StepFiles;

import com.cucumber.listener.Reporter;

import static StepFiles.Hooks.scenario;

public class Logging {
    public static void log(String args) {
        Reporter.addStepLog(args +" ------------- >" +"\n");
        scenario.write(args + "\n");
    }


}
