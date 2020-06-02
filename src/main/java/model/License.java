package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class License {

    @Id
    @GeneratedValue
    @Column(name = "license_id")
    private int id;

    private String licenseNumber;

    private Date issueDate;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
