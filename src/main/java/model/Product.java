package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="model.Product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private int id;

    private String name;

    private int price;

    private String description;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
