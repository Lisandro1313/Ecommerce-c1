package org.example.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantitySold;
    private double totalRevenue;
    private LocalDate generatedDate;


}