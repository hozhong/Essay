package entity;

import java.util.Date;

public class Employee {
    private Integer id;
    private String employeeNo;
    private String password;
    private String name;
    private String email;
    private Integer deptId;
    private String entryTime;
    private Integer positionId;
    private String photo;


    // id 的 getter 方法
    public Integer getId() {
        return id;
    }

    // id 的 setter 方法
    public void setId(Integer id) {
        this.id = id;
    }

    // employeeNo 的 getter 方法
    public String getEmployeeNo() {
        return employeeNo;
    }

    // employeeNo 的 setter 方法
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    // password 的 getter 方法
    public String getPassword() {
        return password;
    }

    // password 的 setter 方法
    public void setPassword(String password) {
        this.password = password;
    }

    // name 的 getter 方法
    public String getName() {
        return name;
    }

    // name 的 setter 方法
    public void setName(String name) {
        this.name = name;
    }

    // email 的 getter 方法
    public String getEmail() {
        return email;
    }

    // email 的 setter 方法
    public void setEmail(String email) {
        this.email = email;
    }

    // deptId 的 getter 方法
    public Integer getDeptId() {
        return deptId;
    }

    // deptId 的 setter 方法
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    // entryTime 的 getter 方法
    public String getEntryTime() {
        return entryTime;
    }

    // entryTime 的 setter 方法
    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    // positionId 的 getter 方法
    public Integer getPositionId() {
        return positionId;
    }

    // positionId 的 setter 方法
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    // photo 的 getter 方法
    public String getPhoto() {
        return photo;
    }

    // photo 的 setter 方法
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeNo='" + employeeNo + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", deptId=" + deptId +
                ", entryTime=" + entryTime +
                ", positionId=" + positionId +
                ", photo='" + photo + '\'' +
                '}';
    }

}
