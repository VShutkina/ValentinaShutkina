package hwjdi.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import hwjdi.entities.MetalColorFormFiller;
import hwjdi.forms.MetalsColorsForm;

public class MetalsColorsPage extends WebPage {

    private MetalsColorsForm metalsColorsForm;

    @XPath("//ul[@class='panel-body-list results']")
    private UIElement resultRecords;

    public void fillForm(MetalColorFormFiller metalColorFormFiller) {
        metalsColorsForm.fillForm(metalColorFormFiller);
    }

    public String getResultRecords() {
        return resultRecords.getText();
    }
}
