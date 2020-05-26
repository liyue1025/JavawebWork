package cn.glut.domain;

public class Administrator {

    private int id;
    private String adminame;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminame() {
        return adminame;
    }

    public void setAdminame(String adminame) {
        this.adminame = adminame;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", adminame='" + adminame + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
