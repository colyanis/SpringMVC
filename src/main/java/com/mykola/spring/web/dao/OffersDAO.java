package com.mykola.spring.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by mtverdok on 4/10/2017.
 */
@Component("offersDao")
public class OffersDAO {
    private NamedParameterJdbcTemplate jdbc;

    public OffersDAO() {
        System.out.println("Successfully loaded OffersDAO.");
    }

//    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    public List<Offer> getOffers() {
        MapSqlParameterSource params = new MapSqlParameterSource("name", "Mike");

        return jdbc.query("select * from offers where name = :name", (resultSet, rowNum) -> {
            Offer offer = new Offer();
            offer.setId(resultSet.getInt("id"));
            offer.setName(resultSet.getString("name"));
            offer.setText(resultSet.getString("text"));
            offer.setEmail(resultSet.getString("email"));

            return offer;
        });
    }
}
