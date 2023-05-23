package org.example.model;

import com.stripe.model.Review;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private double price;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;


}
