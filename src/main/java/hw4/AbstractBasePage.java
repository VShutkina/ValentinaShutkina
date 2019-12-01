package hw4;

import hw4.components.HeaderMenu;
import hw4.components.LeftSide;

public abstract class AbstractBasePage {

    private HeaderMenu headerMenu;
    private LeftSide leftSide;

    protected AbstractBasePage() {
        headerMenu = new HeaderMenu();
        leftSide = new LeftSide();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftSide getLeftSide() {
        return leftSide;
    }
}
