package edu.webserver.user.model;

public class PasswordUpdateDTO {
    private int id;
    private String oldPassword;
    private String nuPassword;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOldPassword() {
        return this.oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNuPassword() {
        return this.nuPassword;
    }

    public void setNuPassword(String nuPassword) {
        this.nuPassword = nuPassword;
    }

}
