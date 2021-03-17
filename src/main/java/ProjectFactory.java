public class ProjectFactory {

    public IProjectInformation createUniqueRecord(String data)
    {
        if (data == null || data.isEmpty())
            return null;
        if ("UniqueCustIdForContractId".equals(data)) {
            return new UniqueCustIdForContractIdImpl();
        }else if("UniqueCustIdForGeoZone".equals(data)){
            return new UniqueCustIdForGeoZoneImpl();
        }else if("ListOfUniqueCustIdForGeoZone".equals(data)){
            return new ListOfUniqueCustIdForGeoZoneImpl();
        }else if("AvgBuildDurationForGeoZone".equals(data)){
            return new AvgBuildDurationForGeoZoneImpl();
        }
        return null;
    }
}
