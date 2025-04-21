package entity;

import java.util.List;
import java.util.Map;

public class CombinedResult {
    private List<Map<String, Object>> departmentList;
    private List<Map<String, Object>> positionList;


    public CombinedResult(List<Map<String, Object>> departmentList, List<Map<String, Object>> positionList) {
        this.departmentList = departmentList;
        this.positionList = positionList;
    }

    public List<Map<String, Object>> getDepartmentList() {
        return departmentList;
    }

    public List<Map<String, Object>> getPositionList() {
        return positionList;
    }


}
