import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ProjectMainTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testNoOfUniQueCustIDsIsSucessfull(){
        ProjectUniqueInformation projectUniqueInformation = new ProjectUniqueInformation();

        String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122";

        String[] tokens = str.split("\\s");
        List<String> projectListRowWise = Arrays.stream(tokens).collect(Collectors.toList());

        //The number of unique customerId for each Geozone.
        projectUniqueInformation.getNoOfUniQueCustIDsForGeoZone(projectListRowWise);

    }

    @Test
    public void testNoOfCustIDsForContractIdIsSucessfull() {
        ProjectUniqueInformation projectUniqueInformation = new ProjectUniqueInformation();

        String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122";

        String[] tokens = str.split("\\s");
        List<String> projectListRowWise = Arrays.stream(tokens).collect(Collectors.toList());

        //The number of unique customerId for each contractId.
        projectUniqueInformation.getNoOfCustIDsForContractId(projectListRowWise);

    }

    @Test
    public void testListOfUniqueCustIdsForGeoZoneIsSucessfull() {
        ProjectUniqueInformation projectUniqueInformation = new ProjectUniqueInformation();

        String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122";

        String[] tokens = str.split("\\s");
        List<String> projectListRowWise = Arrays.stream(tokens).collect(Collectors.toList());

        //The list of unique customerId for each Geozone
        projectUniqueInformation.getListOfUniqueCustIdsForgeoZone(projectListRowWise);

    }



    @Test
    public void testAllRecordIsReturnSucessfull(){
        ProjectUniqueInformation projectUniqueInformation = new ProjectUniqueInformation();

        String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122";

        projectUniqueInformation.getUniQueRecords(str);

    }

    @Test
    public void testData() {

        String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122";

        ProjectInformationService projectUniqueInformation = new ProjectInformationService();
        projectUniqueInformation.getUniqueRecords(str);

    }



}