package com.exammanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "testr")

public class Testr {
	
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name = "testid")
		    private int testid;

		    @Column(name = "email")
		    private String email;

		    @Column(name = "catid")
		    private int catid;

		    // Getters and Setters
		    public int getTestid() {
		        return testid;
		    }

		    public void setTestid(int testid) {
		        this.testid = testid;
		    }

		    public String getEmail() {
		        return email;
		    }

		    public void setEmail(String email) {
		        this.email = email;
		    }

		    public int getCatid() {
		        return catid;
		    }

		    public void setCatid(int catid) {
		        this.catid = catid;
		    }
		}