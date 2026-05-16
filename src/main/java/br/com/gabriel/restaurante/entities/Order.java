package br.com.gabriel.restaurante.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "tb_order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product){
        this.items.add(product);
    }

    public Double getTotalPayment(){
        return items.stream().mapToDouble(Product::getPrice).sum();
    }
}
