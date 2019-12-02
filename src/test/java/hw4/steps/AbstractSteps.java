package hw4.steps;

import hw4.HomePage;
import hw4.MetalsColorsPage;

public abstract class AbstractSteps {

    protected HomePage homePage;
    protected MetalsColorsPage metalsColorsPage;

    public HomePage homePage() {
        return new HomePage();
    }

    public MetalsColorsPage metalsColorsPage() {
        return new MetalsColorsPage();
    }
}
