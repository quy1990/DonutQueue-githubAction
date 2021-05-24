package com.atrify.donutQueue.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order implements Serializable {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "client_id")
    @NotNull
    private Long clientId;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "quantity")
    private int quantity;

    public Order() {
    }

    public Order(Long clientId, int quantity) {
        this.clientId = clientId;
        this.quantity = quantity;
        this.createdDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
