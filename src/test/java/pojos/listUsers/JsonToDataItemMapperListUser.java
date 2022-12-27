package pojos.listUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonToDataItemMapperListUser {

    public static List<DataItemListUser> mapJsonDataToDataItem(List<Map<String, String>> data) {
        List<DataItemListUser> dataItems = new ArrayList<>();
        for (Map<String, String> element : data) {
            DataItemListUser dataItem = new DataItemListUser(element);
            dataItems.add(dataItem);
        }

        return dataItems;
    }
}
