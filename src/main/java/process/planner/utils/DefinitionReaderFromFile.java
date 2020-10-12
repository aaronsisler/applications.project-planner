package process.planner.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DefinitionReaderFromFile {
    public ArrayList<int[]> getProcessDefinition(String filepath) {
        ArrayList<int[]> stepDefinitionList = new ArrayList<>();
        ArrayList<String> rawStepDefinitionList = getRawStepDefinitions(filepath);

        for(String rawStepDef : rawStepDefinitionList) {
            String[] rawEmployeeCountsPerHalfDay = rawStepDef.split(",");
            int[] parsedEmployeeCountsPerHalfDay = new int[rawEmployeeCountsPerHalfDay.length];
            for(int i = 0; i < rawEmployeeCountsPerHalfDay.length; i++) {
                parsedEmployeeCountsPerHalfDay[i] = Integer.parseInt(rawEmployeeCountsPerHalfDay[i]);
            }
            stepDefinitionList.add(parsedEmployeeCountsPerHalfDay);
        }
        return stepDefinitionList;
    }

    private ArrayList<String> getRawStepDefinitions(String filePathname) {
        ArrayList<String> rawStepDefinitionList = new ArrayList<>();
        try {
            File file = new File(filePathname);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String rawData = scanner.nextLine();
                String rawStep = rawData.split("#")[0].trim();
                rawStepDefinitionList.add(rawStep);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePathname);
            e.printStackTrace();
        }

        return rawStepDefinitionList;
    }
}