package com.mykola.spring.web.dao;

import com.mykola.spring.web.validation.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Offer {
    private int id;

    @Size(min = 2, max = 100)
    private String text;

    private User user;

    public Offer() {
        this.user = new User();
    }

    public Offer(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public Offer(int id, User user, String text) {
        this.id = id;
        this.user = user;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user.getUsername() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;

        Offer offer = (Offer) o;

        if (text != null ? !text.equals(offer.text) : offer.text != null) return false;
        return !(user != null ? !user.equals(offer.user) : offer.user != null);

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
