import java.util.*;
import java.util.stream.Collectors;

public class ProjectUniqueInformation {
    public static void main(String[] args) {
        String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122";

        ProjectUniqueInformation projectUniqueInformation = new ProjectUniqueInformation();
        projectUniqueInformation.getUniQueRecords(str);
    }

    /**
     *
     * @param str
     */
    public void getUniQueRecords(String str) {
        if(str != null && !str.isEmpty()) {
            String[] tokens = str.split("\\s");
            List<String> projectListRowWise = Arrays.stream(tokens).collect(Collectors.toList());

            //The number of unique customerId for each contractId.
            getNoOfCustIDsForContractId(projectListRowWise);

            //The number of unique customerId for each Geozone.
            getNoOfUniQueCustIDsForGeoZone(projectListRowWise);

            //The list of unique customerId for each Geozone
            getListOfUniqueCustIdsForgeoZone(projectListRowWise);

            //The average build duration for each Geozone.
            getAverageBuildDurationForGeoZone(projectListRowWise);
        }
    }


    /**
     *
     * @param projectListRowWise
     */
    public void getNoOfCustIDsForContractId(List<String> projectListRowWise) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String projectData : projectListRowWise) {
            String[] split = projectData.split(",");
            if (split.length > 0) {
                map = fillMapWithUniqueVal(split[1],split[0],map);
            }
        }
        dispUniqueRecords(map,Boolean.TRUE);
    }


    /**
     *
     * @param projectListRowWise
     */
    public void getNoOfUniQueCustIDsForGeoZone(List<String> projectListRowWise) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String projectData : projectListRowWise) {
            String[] split = projectData.split(",");
            if (split.length > 0) {
                fillMapWithUniqueVal(split[2] , split[0] , map);
            }
        }
        dispUniqueRecords(map , Boolean.TRUE);
    }

    /**
     *
     * @param projectListRowWise
     */
    public void getListOfUniqueCustIdsForgeoZone(List<String> projectListRowWise) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String projectData : projectListRowWise) {
            String[] split = projectData.split(",");
            if (split.length > 0) {
                map = fillMapWithUniqueVal(split[1] , split[0] , map);
            }
        }
        dispUniqueRecords(map , Boolean.FALSE);
    }

    /**
     *
     * @param projectListRowWise
     */
    public void getAverageBuildDurationForGeoZone(List<String> projectListRowWise) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String projectData : projectListRowWise) {
            String[] split = projectData.split(",");
            if (split.length > 0) {
                map = fillMapWithUniqueVal(split[2] , split[5] , map);
            }
        }
        getAverage(map);
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
        dispAverageByGeoZone(results);
    }

    /**
     *
     * @param results
     */
    public void dispAverageByGeoZone(Map<String, Double> results) {
        Iterator<Map.Entry<String, Double>> iterator = results.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Double> entry = iterator.next();
            System.out.println("The average build duration for the Geo Zone:-" + entry.getKey() +
                    "and value is = " + entry.getValue());
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

    /**
     *
     * @param key
     * @param val
     * @param map
     * @return
     */

    public HashMap<String, List<String>> fillMapWithUniqueVal(String key, String val,
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
     * @param map
     * @param sizeToReturn
     */
    public void dispUniqueRecords(HashMap<String, List<String>> map,Boolean sizeToReturn) {

        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            if(sizeToReturn == Boolean.TRUE) {
                System.out.println("The number of unique customerId for the contractId:-" + entry.getKey() +
                        "and the size is = " + entry.getValue().size());
            }else{
                System.out.println("The number of unique customerId for the contractId:-" + entry.getKey() +
                        "and the size is = " + entry.getValue());
            }
        }
    }
}
