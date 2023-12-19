package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "Customer_id", referencedColumnName = "id")
    @JsonIgnore
    private Customer customer;



    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer quantity;
    @Column
    private double totalPrice;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "invoice")
    private Set<ProductDetails> productDetails;

}
