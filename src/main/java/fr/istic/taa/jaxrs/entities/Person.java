package fr.istic.taa.jaxrs.entities;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@XmlRootElement(name = "Person")
public class Person implements Serializable {

    @XmlElement(name = "id")
    private long id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "firstname")
    private String firstname;

    @XmlElement(name = "age")
    private long age;

    /* Mapstruct is used when using the DTO(data transfer object)
    for example when want to exclude the id and just use name and age */



}
