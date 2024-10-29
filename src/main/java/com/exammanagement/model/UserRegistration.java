package com.exammanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "login_details")

public class UserRegistration {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "userid")
	    private int userid;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "dob")
	    private String dob;

	    @Column(name = "gender")
	    private String gender;

	    @Column(name = "qualification")
	    private String qualification;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "password")
	    private String password;

	    @Column(name = "city")
	    private String city;

	    @Column(name = "state")
	    private String state;

	    @Column(name = "pincode")
	    private String pincode;

	    @Column(name = "usertype")
	    private String usertype;

	    @Column(name = "verifystring")
	    private String verifyString;

	    @Column(name = "address")
	    private String address;

	    // Getters and Setters

	    public int getUserid() {
	        return userid;
	    }

	    public void setUserid(int userid) {
	        this.userid = userid;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDob() {
	        return dob;
	    }

	    public void setDob(String dob) {
	        this.dob = dob;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getQualification() {
	        return qualification;
	    }

	    public void setQualification(String qualification) {
	        this.qualification = qualification;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public String getState() {
	        return state;
	    }

	    public void setState(String state) {
	        this.state = state;
	    }

	    public String getPincode() {
	        return pincode;
	    }

	    public void setPincode(String pincode) {
	        this.pincode = pincode;
	    }

	    public String getUsertype() {
	        return usertype;
	    }

	    public void setUsertype(String usertype) {
	        this.usertype = usertype;
	    }

	    public String getVerifyString() {
	        return verifyString;
	    }

	    public void setVerifyString(String verifyString) {
	        this.verifyString = verifyString;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }
	}