package definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReportingDefinitions extends DefinitionUtils {

    private static boolean reportDeleteDone = false;

    @Given("^I have deleted any previous reports$")
    public void deletePreviousReports() {
        if (!reportDeleteDone) {
            File reportFile = new File(reportFileName);
            reportFile.delete();
            reportDeleteDone = true;
        }
    }

    @Then("^I capture dash board details$")
    public void captureDashBoard() throws IOException {
        waitForElementTobeVisible(By.cssSelector(".comission-bg"));
        String commission = driver.findElement(By.cssSelector(".comission-bg .value-panel")).getText();

        waitForElementTobeVisible(By.cssSelector(".trade-bg"));
        String trade = driver.findElement(By.cssSelector(".trade-bg .value-panel")).getText();

        waitForElementTobeVisible(By.cssSelector(".box-mypackage"));
        String myPackage = driver.findElement(By.cssSelector(".box-mypackage .value-panel")).getText();

        waitForElementTobeVisible(By.className("info-monitoring"));
        List<WebElement> tradingDays = driver.findElements(By.className("info-monitoring"));

        myPackage = myPackage.replace("TCOIN", "");
        commission = commission.replace("TCOIN", "");
        trade = trade.replace("TCOIN", "");

        writeToFile(myPackage, trade, commission, tradingDays);
    }

}
