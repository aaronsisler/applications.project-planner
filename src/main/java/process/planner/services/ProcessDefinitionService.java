package process.planner.services;

import process.planner.models.Process;
import process.planner.models.Step;

public class ProcessDefinitionService {
    public Process createProcess(int staggerDays) {
        Process process = new Process(staggerDays);

        for (int i = 1; i < 5; i++) {
            Step tempStep;
            if (i % 2 == 0) {
                tempStep = new Step(i, 1);
            } else {
                tempStep = new Step(i);
            }

            process.addStep(tempStep);
        }

        return process;
    }
}