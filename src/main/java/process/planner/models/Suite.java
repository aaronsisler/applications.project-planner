package process.planner.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Suite {
    private ArrayList<LocalDate> processDates = new ArrayList<>();
    private Process process;

    public ArrayList<LocalDate> getProcessDates() {
        return processDates;
    }

    public void setProcessDates(ArrayList<LocalDate> processDates) {
        this.processDates = processDates;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
}
