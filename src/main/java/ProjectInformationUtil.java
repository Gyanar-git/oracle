import java.util.*;
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



    /**
     *
     * @param results
     */
    public static void dispAverageByGeoZone(Map<String, Double> results) {
        Iterator<Map.Entry<String, Double>> iterator = results.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Double> entry = iterator.next();
            System.out.println("The average build duration for the Geo Zone:-" + entry.getKey() +
                    " and value is = " + entry.getValue());
        }
    }

    /**
     *
     * @param values
     * @return
     */
    public static Double calcAverage(List<String> values) {
        double result = 0;
        for (String value : values) {
            result += Double.parseDouble(value);
        }
        return result / values.size();
    }
}
