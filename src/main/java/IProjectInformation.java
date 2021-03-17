import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface IProjectInformation {

    HashMap<String, List<String>>  getUniqueRecords(String str);

    default void displayRecords(HashMap<String, List<String>> map, Boolean sizeToReturn){
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            if(sizeToReturn == Boolean.TRUE) {
                System.out.println("The number of unique record for:-" + entry.getKey() +
                        " and the size is = " + entry.getValue().size());
            }else{
                System.out.println("The number of unique record for:-" + entry.getKey() +
                        " and the size is = " + entry.getValue());
            }
        }
    }
}
