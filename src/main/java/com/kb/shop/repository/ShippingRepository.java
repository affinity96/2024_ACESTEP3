package com.kb.shop.repository;

import com.kb.shop.domain.Seller;
import com.kb.shop.domain.ShippingInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingRepository {

    private final JdbcTemplate jdbcTemplate;

    public ShippingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ShippingInfo selectShippingInfo(Long id) {
        String sql = "SELECT * FROM shippinginfo WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(ShippingInfo.class));
    }

    public ShippingInfo selectSelectInfoByOrderId (Long oderId) {
        String sql = "SELECT * FROM shippinginfo WHERE order_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{oderId}, BeanPropertyRowMapper.newInstance(ShippingInfo.class));
    }

    public void updateUpdateShippingStatus(Long id, ShippingInfo shippingInfo) {
        String sql = "UPDATE shippinginfo SET shipping_status = ? WHERE id = ?";
        jdbcTemplate.update(sql, shippingInfo.getShippingStatus(), id);
    }

    public void deleteShippingInfo(Long id) {
        String sql = "DELETE FROM shippinginfo WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        String sql = "INSERT INTO shippinginfo (order_id, order_item_id, shipping_status) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, shippingInfo.getOrderId(), shippingInfo.getOrderItemId(), shippingInfo.getShippingStatus());
    }
}
