package com.atrify.donutQueue.dataTranferObjects;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class OrderDTO implements Serializable {

    private int id;
    private Long clientId;
    private LocalDateTime createdDate;
    private int quantity;
    private String ApproximateTime;

    public OrderDTO() {
    }

    public OrderDTO(Long clientId, int quantity) {
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

    public String getApproximateTime() {
        return ApproximateTime;
    }

    public void setApproximateTime(String approximateTime) {
        ApproximateTime = approximateTime;
    }
}
