package pojos.listResources;

import java.util.Map;

public class DataItemListResources {
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantoneValue;

    public DataItemListResources(Map<String, String> data) {
        Object year = data.get("year");
        Object id = data.get("id");
        try {
            if (id instanceof Integer) {
                this.id = (int) id;
            }
            this.name = data.get("name");
            if (year instanceof Integer) {
                this.year = (int) year;
            }
            this.color = data.get("color");

            this.pantoneValue = data.get("pantone_value");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPantoneValue() {
        return pantoneValue;
    }
}
