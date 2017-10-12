package com.epam.lab.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "letters")
public class Letters {

    @XmlElement(name = "letter", type = Letter.class)
    private List<Letter> letters = new ArrayList<>();

    public List<Letter> getLetters() {
        return letters;
    }
}