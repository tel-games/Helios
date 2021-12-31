package cz.helios.school.models;

import java.util.Date;

public class Member {
    private String id;
    private String name;
    private String school;
    private String joinedDate;
    private Date createDate;

    public Member(String name, String id, String school, String joinedDate) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.joinedDate = joinedDate;
        this.createDate = new Date();
    }
}
