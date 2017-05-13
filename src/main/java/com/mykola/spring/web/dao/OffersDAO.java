package com.mykola.spring.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Offer> getOffers(String username) {
        return jdbc.query("select * from offers, users where offers.username = users.username",
                new MapSqlParameterSource("username", username), new OfferRowMapper());
    }

    public List<Offer> getOffers() {
        return jdbc.query("select * from offers, users where offers.username = users.username", new OfferRowMapper());
    }

    public boolean create(Offer offer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

        return jdbc.update("insert into offers (username, text) values (:username, :text)", params) == 1;
    }

    @Transactional
    public int[] create(List<Offer> offers) {
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
        return jdbc.batchUpdate("insert into offers (username, text) values (:username, :text)", params);
    }


    public boolean update(Offer offer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

        return jdbc.update("update offers set text = :text where id = :id", params) == 1;
    }



    public Offer getOffer(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.query("select * from offers, users where " +
                        "offers.username = users.username and id=:id", params,
                (resultSet, rowNumber) -> {
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
                }).stream().findAny().orElse(null);

    }

    public boolean delete(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        return jdbc.update("delete from offers where id=:id", params) == 1;
    }

}
