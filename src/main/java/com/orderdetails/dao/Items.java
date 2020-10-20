package com.orderdetails.dao;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Items {
    private Integer itemID;
    private String itemName;
    private double price;
    private LocalDateTime addedDate;
}
