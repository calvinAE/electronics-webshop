package ehb.be.webapp.model;

import jakarta.persistence.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.Type;

import java.util.Arrays;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    @ManyToOne
    private Category category;
    private String description;
    private double price;

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String name, Category category, String description, double price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }
}

