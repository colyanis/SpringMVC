package com.mykola.spring.web.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by M on 13.05.2017.
 */
public class OfferRowMapper implements RowMapper<Offer> {

    public Offer mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setEmail(resultSet.getString("email"));
        user.setName(resultSet.getString("name"));
        user.setAuthority(resultSet.getString("authority"));
        user.setEnabled(resultSet.getBoolean("enabled"));
        user.setUsername(resultSet.getString("username"));


        Offer offer = new Offer();
        offer.setId(resultSet.getInt("id"));
        offer.setText(resultSet.getString("text"));
        offer.setUser(user);

        return offer;
    }
}
