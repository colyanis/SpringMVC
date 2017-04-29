package com.mykola.spring.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by mtverdok on 4/10/2017.
 */
@Component("offersDao")
public class OffersDao {
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    public List<Offer> getOffers() {
        return jdbc.query("select * from offers", (resultSet, rowNum) -> {
            Offer offer = new Offer();
            offer.setId(resultSet.getInt("id"));
            offer.setName(resultSet.getString("name"));
            offer.setText(resultSet.getString("text"));
            offer.setEmail(resultSet.getString("email"));

            return offer;
        });
    }

    public boolean create(Offer offer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

        return jdbc.update("insert into offers (name, email, text) values (:name, :email, :text)", params) == 1;
    }

    public Offer getOffer(int i) {
        MapSqlParameterSource params = new MapSqlParameterSource();


        return jdbc.query("select * from offers where id=:id", params,
                (rs, rowNumber) -> {
                    Offer offer = new Offer();
                    offer.setId(rs.getInt("id"));
                    offer.setName(rs.getString("name"));
                    offer.setEmail(rs.getString("id"));
                    offer.setText(rs.getString("text"));
                    return offer;
                }).stream().findAny().orElse(null);

    }
}
