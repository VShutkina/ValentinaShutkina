package hw4.common;

import java.util.List;

public class MetalColorPageTestData {

    private List<String> summaryList;
    private List<String> elementsList;
    private String color;
    private String metal;
    private List<String> vegetablesList;

    public MetalColorPageTestData(List<String> summaryList, List<String> elementsList, String color, String metal, List<String> vegetablesList) {
        this.summaryList = summaryList;
        this.elementsList = elementsList;
        this.color = color;
        this.metal = metal;
        this.vegetablesList = vegetablesList;
    }

    public static MetalColorBuilder metalColorBuilder() {
        return new MetalColorBuilder();
    }

    public List<String> getSummaryList() {
        return summaryList;
    }

    public List<String> getElementsList() {
        return elementsList;
    }

    public String getColor() {
        return color;
    }

    public String getMetal() {
        return metal;
    }

    public List<String> getVegetablesList() {
        return vegetablesList;
    }

    @Override
    public String toString() {
        return "MetalColorPageDataProvider{" +
                "summaryList=" + summaryList +
                ", elementsList=" + elementsList +
                ", color='" + color + '\'' +
                ", metal='" + metal + '\'' +
                ", vegetablesList=" + vegetablesList +
                '}';
    }

    public static class MetalColorBuilder {
        private List<String> summaryList;
        private List<String> elementsList;
        private String color;
        private String metal;
        private List<String> vegetablesList;

        private MetalColorBuilder() {
        }

        public MetalColorBuilder setSummaryList(List<String> summaryList) {
            this.summaryList = summaryList;
            return this;
        }

        public MetalColorBuilder setElementsList(List<String> elementsList) {
            this.elementsList = elementsList;
            return this;
        }

        public MetalColorBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public MetalColorBuilder setMetal(String metal) {
            this.metal = metal;
            return this;
        }

        public MetalColorBuilder setVegetablesList(List<String> vegetablesList) {
            this.vegetablesList = vegetablesList;
            return this;
        }

        public MetalColorPageTestData build() {
            return new MetalColorPageTestData(
                    this.summaryList,
                    this.elementsList,
                    this.color,
                    this.metal,
                    this.vegetablesList
            );
        }
    }
}
