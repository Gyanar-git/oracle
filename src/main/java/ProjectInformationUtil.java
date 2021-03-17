import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectInformationUtil {

    /**
     *
     * @param key
     * @param val
     * @param map
     * @return
     */

    public static HashMap<String, List<String>> fillMapWithUniqueVal(String key, String val,
                                                              HashMap<String, List<String>> map){
        if (map.containsKey(key)) {
            map.get(key).add(val);
        } else {
            map.put(key, new LinkedList<>(Arrays.asList(new String[]{val})));
        }
        return map;
    }

    /**
     *
     * @param str
     * @return
     */

    public static List<String> getRowWiseData(String str){
        String[] tokens = str.split("\\s");
        List<String> projectListRowWise = Arrays.stream(tokens).collect(Collectors.toList());
        return projectListRowWise;
    }
}
