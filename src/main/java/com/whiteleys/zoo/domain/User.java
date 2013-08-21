package com.whiteleys.zoo.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * A registered user of the system. 
 */
@Entity
public class User implements Serializable {

    private Long userId;
    @Pattern(regexp = "\\w+", message="username must have letters and/or numbers")
    private String username;
    @Pattern(regexp = "\\w+", message="password must have letters and/or numbers")
    private String password;
    @Pattern(regexp = "\\w+", message="password must have letters and/or numbers")
    private transient String password2; //TODO: password must match
    private transient Integer dobDay;
    private transient Integer dobMonth;
    private transient Integer dobYear;
    @Past
    private Date dateOfBirth;
    @NotNull(message = "Please enter a valid postcode")
    private String postcode;
    @NotNull(message = "Please select a gender")
    private Sex sex;


    public Integer getDobDay() {
        return dobDay;
    }

    public void setDobDay(Integer dobDay) {
        this.dobDay = dobDay;
    }

    public Integer getDobMonth() {
        return dobMonth;
    }

    public void setDobMonth(Integer dobMonth) {
        this.dobMonth = dobMonth;
    }

    public Integer getDobYear() {
        return dobYear;
    }

    public void setDobYear(Integer dobYear) {
        this.dobYear = dobYear;
    }

    // Default Constructor
    public User() {

    }

    /**
     * @return the unique id of this user
     */
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    public Long getUserId() {
        return userId;
    }

    /**
     * @return the unique username of this user
     */
    @Column(name="username", unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    /**
     * @return the user's password
     */
    @Column(name="password", nullable = false)
    public String getPassword() {
        return password;
    }

    /**
     * @return the user's date of birth
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dateofbirth", nullable = false)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @return the user's sex
     */
    @Column(name="sex", nullable = false, length = 1)
    public Sex getSex() {
        return sex;
    }

    /**
     * @return the user's postcode
     */
    @Column(name="postcode", nullable = false)
    public String getPostcode() {
        return postcode;
    }


    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
