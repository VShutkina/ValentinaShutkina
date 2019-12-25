package hwjdi.entities;

import java.util.Arrays;

import static java.lang.String.format;

public class MetalColorFormFiller {

    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public int[] getSummary() {
        return summary;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    @Override
    public String toString() {
        return format("Summary: %d\nElements: %s\nColor: %s\nMetal: %s\nVegetables: %s",
                Arrays.stream(summary).sum(),
                Arrays.toString(elements),
                color,
                metals,
                Arrays.toString(vegetables)
        );
    }
}
