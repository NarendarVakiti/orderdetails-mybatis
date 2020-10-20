package com.orderdetails;

import com.orderdetails.dao.Items;
import com.orderdetails.mapper.OrderDetails;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Mapper Interface scan
@MapperScan("com.orderdetails.mapper")
// Mapped POJO classes, Declare here all the Mapped Type how many we have
@MappedTypes(Items.class)
@SpringBootApplication
public class OrderdetailsMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderdetailsMybatisApplication.class, args);
	}

}
