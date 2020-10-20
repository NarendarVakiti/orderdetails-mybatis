package com.orderdetails.controller;

import com.orderdetails.dao.Items;
import com.orderdetails.mapper.OrderDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
public class OrderDetailsController {

    @Autowired
    private OrderDetails orderDetails;

    @PostMapping("/saveitems")
    public List<Items> saveItems(@RequestBody Items items){
        log.info("Requested Item details : {}", items);
        items.setAddedDate(LocalDateTime.now());
        orderDetails.saveItemDetails(items);
        log.info("Item details saved successfully");
        return orderDetails.getItems();
    }

    @GetMapping("/getitems")
    public List<Items> getItems(){
        List<Items> items = orderDetails.getItems();
        log.info("All Items details : {}", items);
        return items;
    }

    @GetMapping("/getitembyname/{itemName}")
    public Items getItemByName(@PathVariable String itemName){
        log.info("Item name {}", itemName);
        Items items = orderDetails.getItemByName(itemName);
        if(null == items){
            log.info("Item details not found");
        }else{
            log.info("Item details : {}", items);
        }
        return items;
    }

    @DeleteMapping("/deleteitembyname/{itemName}")
    public String deleteItemByName(@PathVariable String itemName){
        log.info("Delete item name {}", itemName);
        orderDetails.deleteItemByName(itemName);
        log.info("Item details deleted");
        return "deleted item "+itemName+" successfully";
    }

    @PutMapping("/updateitem")
    public void updateItemDetails(@RequestBody Items items){
        log.info("Update item details {}", items);
        orderDetails.updateItemDetails(items);
        log.info("Item details updated");
    }

}
