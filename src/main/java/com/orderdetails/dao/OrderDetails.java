package com.orderdetails.dao;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDetails {
    private int orderID;
    private LocalDateTime orderDate;
    private List<Items> itemsList;
}
