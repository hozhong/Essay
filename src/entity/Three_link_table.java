package entity;

import java.util.List;
import java.util.Map;

public class Three_link_table {
    private List<Map<String, Object>> departmentList;
    private List<Map<String, Object>> positionList;
    private List<User> userlist;

    public Three_link_table(List<Map<String, Object>> departmentList, List<Map<String, Object>> positionList, List<User> userlist) {
        this.departmentList = departmentList;
        this.positionList = positionList;
        this.userlist = userlist;
    }

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    public List<Map<String, Object>> getDepartmentList() {
        return departmentList;
    }

    public List<Map<String, Object>> getPositionList() {
        return positionList;
    }

    @Override
    public String toString() {
        return "Three_link_table{" +
                "departmentList=" + departmentList +
                ", positionList=" + positionList +
                ", userlist=" + userlist +
                '}';
    }
}
