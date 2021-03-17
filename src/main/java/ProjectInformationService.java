import java.util.HashMap;
import java.util.List;

public class ProjectInformationService{

    public static void main(String[] args)
    {
        String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122";

        getUniqueRecords(str);

    }

    public static void  getUniqueRecords(String str){
        ProjectFactory projectFactory = new ProjectFactory();
        //The number of unique customerId for each contractId.
        IProjectInformation projectInformation = projectFactory.createUniqueRecord("UniqueCustIdForContractId");
        HashMap<String, List<String>> uniqueRecords = projectInformation.getUniqueRecords(str);
        projectInformation.displayRecords(uniqueRecords, Boolean.TRUE);

        //The number of unique customerId for each Geozone.

        IProjectInformation projectInformation1 = projectFactory.createUniqueRecord("UniqueCustIdForGeoZone");
        HashMap<String, List<String>> uniqueRecords1 = projectInformation1.getUniqueRecords(str);
        projectInformation.displayRecords(uniqueRecords1, Boolean.TRUE);

        ////The list of unique customerId for each Geozone


        IProjectInformation projectInformation2 = projectFactory.createUniqueRecord("ListOfUniqueCustIdForGeoZone");
        HashMap<String, List<String>> uniqueRecords2 = projectInformation2.getUniqueRecords(str);
        projectInformation.displayRecords(uniqueRecords2, Boolean.FALSE);

        //The average build duration for each Geozone.

        IProjectInformation projectInformation3 = projectFactory.createUniqueRecord("AvgBuildDurationForGeoZone");
        HashMap<String, List<String>> uniqueRecords3 = projectInformation3.getUniqueRecords(str);
        projectInformation.displayRecords(uniqueRecords3, Boolean.FALSE);
    }

}
