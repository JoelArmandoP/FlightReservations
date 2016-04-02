package com.joel.flightreservations.domain.model.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * An online traveller who can create and book travel itineraries.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "Select a from User a"),
        @NamedQuery(name = "User.findByUsername",
                query = "Select a from User a where a.username = :username")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String password;
    @Embedded
    private Search lastSearch;
    @NotNull
    private String email;
    @Embedded
    private CreditCard creditCard;

    public User(String username, String firstname, String lastname, String password,
                String email, CreditCard creditCard) {
        setUsername(username);
        setFirstname(firstname);
        setLastname(lastname);
        setPassword(password);
        setEmail(email);
        setLastSearch(new Search());
        setCreditCard(creditCard);
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() { return lastname;    }

    public void setLastname(String lastname) { this.lastname = lastname;    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Search getLastSearch() {
        return lastSearch;
    }

    public void setLastSearch(Search lastSearch) {
        this.lastSearch = lastSearch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" +firstname + " "+ lastname + '\'' +
                ", username='" + username + '\'' +
                ", lastSearch=" + lastSearch +
                '}';
    }
}
