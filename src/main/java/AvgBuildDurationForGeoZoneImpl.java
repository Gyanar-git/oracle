import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvgBuildDurationForGeoZoneImpl implements IProjectInformation {

    @Override
    public HashMap<String, List<String>> getUniqueRecords(String str) {
        List<String> projectListRowWise = ProjectInformationUtil.getRowWiseData(str);

        HashMap<String, List<String>> map = new HashMap<>();
        for (String projectData : projectListRowWise) {
            String[] split = projectData.split(",");
            if (split.length > 0) {
                map = ProjectInformationUtil.fillMapWithUniqueVal(split[2] , split[5] , map);
            }
        }
        getAverage(map);
        return map;
    }

    /**
     *
     * @param map
     */
    public void getAverage(HashMap<String, List<String>> map) {
        Map<String, Double> results = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Double average = calcAverage(entry.getValue());
            results.put(entry.getKey(), average);
        }
    }

    /**
     *
     * @param values
     * @return
     */
    public Double calcAverage(List<String> values) {
        double result = 0;
        for (String value : values) {
            result += Double.parseDouble(value);
        }
        return result / values.size();
    }
}
