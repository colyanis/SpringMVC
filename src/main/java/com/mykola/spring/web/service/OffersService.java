package com.mykola.spring.web.service;

import com.mykola.spring.web.dao.Offer;
import com.mykola.spring.web.dao.OffersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("offersService")
public class OffersService {

    private OffersDao offersDao;

    @Autowired
    public void setOffersDao(OffersDao offersDao) {
        this.offersDao = offersDao;
    }

    public List<Offer> getCurrent() {
        return offersDao.getOffers();
    }

    public void create(Offer offer) {
        offersDao.create(offer);
    }

    public void throwTestException() {
        offersDao.getOffer(9999);
    }
}
