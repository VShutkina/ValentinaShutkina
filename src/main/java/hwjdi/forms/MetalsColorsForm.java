package hwjdi.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hwjdi.entities.MetalColorFormFiller;

import static hwjdi.enums.VegetablesItems.VEGETABLES;

public class MetalsColorsForm extends Form<MetalColorFormFiller> {

    @FindBy(id = "submit-button")
    private Button submitButton;

    @Css("p.radio>label")
    private WebList summaryRadioButtons;

    @Css(".checkbox>label")
    private WebList checkboxElements;

    @Css("button[title='Colors']")
    private Button colorButton;

    @Css("//div[contains(@class, 'uui-form-element open')]//li//a")
    private DropdownExpand dropdownOptions;

    @Css("#salad-dropdown>button")
    private Button vegetablesButton;

    @Css("ul.dropdown-menu>li>a>label")
    private WebList vegetablesDropdownItems;

    @Css("button[title='Metals']")
    private Button metalButton;

    public void fillForm(MetalColorFormFiller metalColorFormFiller) {
        for (int i : metalColorFormFiller.getSummary()) {
            summaryRadioButtons.select(Integer.toString(i));
        }
        checkboxElements.select(metalColorFormFiller.getElements());
        colorButton.click();
        dropdownOptions.select(metalColorFormFiller.getColor());
        metalButton.click();
        dropdownOptions.select(metalColorFormFiller.getMetals());
        vegetablesButton.click();
        vegetablesDropdownItems.select(VEGETABLES.getValue());
        vegetablesDropdownItems.select(metalColorFormFiller.getVegetables());
        submitButton.click();
    }
}
