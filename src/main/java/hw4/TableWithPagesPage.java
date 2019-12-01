package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class TableWithPagesPage extends AbstractBasePage {

    @FindBy(css = "select.uui-form-element")
    private SelenideElement showTableEntitiesDropdown;

    @FindBy(id = "mCSB_1")
    private SelenideElement RightSide;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']//li[contains(.,'new value')]")
    private SelenideElement logRecord;

    @FindBy(css = "tr[class]")
    private ElementsCollection tableRows;

    @FindBy(css = "input[type='search']")
    private SelenideElement searchInput;

    @FindBy(xpath = "//tr//td[2]")
    private ElementsCollection sortedTableRows;

    public TableWithPagesPage() {
        page(this);
    }

    public SelenideElement getShowTableEntitiesDropdown() {
        return showTableEntitiesDropdown;
    }

    public SelenideElement getRightSide() {
        return RightSide;
    }

    public SelenideElement getLogRecord() {
        return logRecord;
    }

    public ElementsCollection getTableRows() {
        return tableRows;
    }

    public SelenideElement getSearchInput() {
        return searchInput;
    }

    public ElementsCollection getSortedTableRows() {
        return sortedTableRows;
    }
}
