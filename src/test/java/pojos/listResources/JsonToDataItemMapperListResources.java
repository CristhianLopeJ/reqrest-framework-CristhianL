package pojos.listResources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonToDataItemMapperListResources {

    public static List<DataItemListResources> mapJsonDataToDataItemListResources(List<Map<String, String>> data) {
        List<DataItemListResources> dataItems = new ArrayList<>();
        for (Map<String, String> element : data) {
            DataItemListResources dataItem = new DataItemListResources(element);
            dataItems.add(dataItem);
        }
        return dataItems;
    }
}
