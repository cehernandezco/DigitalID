package com.example.digitalid.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable {

    public static final String USER_KEY = "user_key";
    public static final String USER_ID = "user_id";

    public Long id;
    public String name;
    public String lastname;
    public Integer country;
    public String email;
    public String username;
    public String password;
    public Date dob;
    private Integer passcode;
    private Integer loginBiometrics;

    public User() {

    }

    public User(Long id, String name, String lastname, Integer country, String email, String username, String password, Date dob) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.country = country;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
    }
    public User(Long id, String name, String lastname, Integer country, String email, String username, Date dob) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.country = country;
        this.email = email;
        this.username = username;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getPasscode() {
        return passcode;
    }

    public void setPasscode(Integer passcode) {
        this.passcode = passcode;
    }

    public Integer getLoginBiometrics() {
        return loginBiometrics;
    }

    public void setLoginBiometrics(Integer loginBiometrics) {
        this.loginBiometrics = loginBiometrics;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", country=" + country +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dob=" + dob +
                ", passcode=" + passcode +
                ", loginBiometrics=" + loginBiometrics +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
