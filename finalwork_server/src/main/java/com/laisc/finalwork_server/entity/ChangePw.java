package com.laisc.finalwork_server.entity;

public class ChangePw {
    private Integer id = 0;
    private String oldPw = "";
    private String newPw = "";

    public ChangePw() {
    }

    public ChangePw(Integer id, String oldPw, String newPw) {
        this.id = id;
        this.oldPw = oldPw;
        this.newPw = newPw;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOldPw() {
        return oldPw;
    }

    public void setOldPw(String oldPw) {
        this.oldPw = oldPw;
    }

    public String getNewPw() {
        return newPw;
    }

    public void setNewPw(String newPw) {
        this.newPw = newPw;
    }

    @Override
    public String toString() {
        return "ChangePw{" +
                "id=" + id +
                ", oldPw='" + oldPw + '\'' +
                ", newPw='" + newPw + '\'' +
                '}';
    }
}
