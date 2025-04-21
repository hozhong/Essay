package entity;

public class User {
    private int id;
    private String e;
    private int p;
    private  String name;
    private String email;
    private Integer deptid;
    private String entryTime;
    private Integer positionid;
    private String photo;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", e='" + e + '\'' +
                ", p=" + p +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", deptid=" + deptid +
                ", entryTime='" + entryTime + '\'' +
                ", positionid=" + positionid +
                ", photo='" + photo + '\'' +
                '}';
    }
}
