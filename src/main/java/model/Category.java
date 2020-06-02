package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    //FetchType.LAZY -> one 쪽에서 사용(category가 매번 해당 category에 속한 product를 다 읽지 않도록 LAZY주는것.) , 성능을 좋게 하기 위해.
    //One쪽 default는 LAZY , many 쪽 default는 EAGER.
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<Product>();

}
