package com.joel.flightreservations.domain.model.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.TimeZone;

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
    private String name;
    @NotNull
    private String password;
    @Embedded
    private Search lastSearch;


    public User(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.lastSearch = new Search();

    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "User{"  +
                " name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", lastSearch=" + lastSearch +
                '}';
    }
}
