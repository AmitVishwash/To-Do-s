package bdd.utility;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ReportGenerator {

    public static void main(String[] args) throws IOException    {

        File reportOutputDirectory = new File("target/report");  //report file name
        List<String> jsonFiles = new ArrayList<>();
        try (Stream<Path> paths = Files.find(Paths.get("target")  //feature file path
                , Integer.MAX_VALUE
                , (path, attr) -> attr.isRegularFile() && path.toString().endsWith("cucumber.json")))    {
                        paths.forEach(path ->    {
                                jsonFiles.add(path.toFile().getAbsolutePath());
            });
        }

        String buildNumber = "1";
        String projectName = "To-Do's";


        Configuration configuration = new Configuration(reportOutputDirectory,projectName);
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("Platform", "Windows 10");
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Branch", "master");
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        ReportBuilder reportBuilder=new ReportBuilder(jsonFiles,configuration);
        Reportable result=reportBuilder.generateReports();
    }
}