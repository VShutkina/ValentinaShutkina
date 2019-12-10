package hw6.common;

import java.util.ArrayList;
import java.util.List;

public enum TestStorage {

    INSTANCE;

    private List<String> optionsList = new ArrayList<>();

    public List<String> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<String> optionsList) {
        this.optionsList = optionsList;
    }
}
