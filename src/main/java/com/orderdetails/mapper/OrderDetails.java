package com.orderdetails.mapper;

import com.orderdetails.dao.Items;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDetails {

    // POJO class props and DB Table coloumn names should be match
    @Insert("insert into items(itemName, price, addedDate) " +
            "values(#{itemName}, #{price}, #{addedDate})")
    //Generate Id based on the last inserted Id
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "itemID",
            before = false, resultType = Integer.class)
    public void saveItemDetails(Items items);

    @Select("select * from items")
    public List<Items> getItems();

    @Select("select * from items where itemName = #{itemName}")
    public Items getItemByName(String itemName);

    @Delete("delete from items where itemName = #{itemName}")
    public void deleteItemByName(String itemName);

    @Update("update items set price = #{price} where itemName = #{itemName}")
    public void updateItemDetails(Items items);

}
