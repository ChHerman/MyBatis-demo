package com.hc.mybatis.dao;

import com.hc.mybatis.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    Order queryOrderWithUserByOrderNumber(@Param("number") String number);
    Order queryOrderWithUserAndDetailByOrderNumber(@Param("number") String number);
    Order queryOrderWithUserAndDetailItemByOrderNumber(@Param("number") String number);
}
