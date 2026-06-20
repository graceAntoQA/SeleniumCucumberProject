package runner;
import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;

import java.io.File;


    @CucumberOptions(features = {"src/test/resources/features"},
            glue = {"stepdefinitions"},

            plugin = {"pretty", "html:target/cucumber-report.html"}
    )

    public class RunnerClass extends AbstractTestNGCucumberTests {





}
