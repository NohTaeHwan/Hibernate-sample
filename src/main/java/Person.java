import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;

    private String lastName;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private License license;
}
