import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueCustIdForGeoZoneImpl implements IProjectInformation {

    @Override
    public HashMap<String, List<String>> getUniqueRecords(String str) {
        List<String> projectListRowWise = ProjectInformationUtil.getRowWiseData(str);

        HashMap<String, List<String>> map = new HashMap<>();
        for (String projectData : projectListRowWise) {
            String[] split = projectData.split(",");
            if (split.length > 0) {
                ProjectInformationUtil.fillMapWithUniqueVal(split[2] , split[0] , map);
            }
        }
        return map;
    }
}
