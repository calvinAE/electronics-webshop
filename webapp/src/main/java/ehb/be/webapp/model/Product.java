package ehb.be.webapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "category_id", nullable = false)
    private Category category;
    private String description;
    private double price;


    public Product(String name, Category category, String description, double price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }
}

