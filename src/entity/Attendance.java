package entity;

public class Attendance {
    private Integer id;
    private Integer employeeId;
    private String signInTime;
    private String signOutTime;



    // id 的 getter 方法
    public Integer getId() {
        return id;
    }

    // id 的 setter 方法
    public void setId(Integer id) {
        this.id = id;
    }

    // employeeId 的 getter 方法
    public Integer getEmployeeId() {
        return employeeId;
    }

    // employeeId 的 setter 方法
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    // signInTime 的 getter 方法
    public String getSignInTime() {
        return signInTime;
    }

    // signInTime 的 setter 方法
    public void setSignInTime(String signInTime) {
        this.signInTime = signInTime;
    }

    // signOutTime 的 getter 方法
    public String getSignOutTime() {
        return signOutTime;
    }

    // signOutTime 的 setter 方法
    public void setSignOutTime(String signOutTime) {
        this.signOutTime = signOutTime;
    }
}
