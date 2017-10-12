package com.epam.lab.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Users {

    @XmlElement(name = "user", type = User.class)
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }
}
