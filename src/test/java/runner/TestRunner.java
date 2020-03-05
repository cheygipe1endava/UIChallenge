package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import helper.HookHelper;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"steps","helper"})
public class TestRunner{
}