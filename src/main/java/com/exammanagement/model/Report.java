package com.exammanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "report")

public class Report {
	
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name = "reportid")
		    private int reportId;

		    @Column(name = "testid")
		    private int testId;

		    @Column(name = "catid")
		    private int catId;

		    @Column(name = "totalq")
		    private int totalQ;

		    @Column(name = "correctans")
		    private int correctAns;

		    @Column(name = "wrongans")
		    private int wrongAns;

		    @Column(name = "email")
		    private String email;

		    // Getters and Setters
		    public int getReportId() {
		        return reportId;
		    }

		    public void setReportId(int reportId) {
		        this.reportId = reportId;
		    }

		    public int getTestId() {
		        return testId;
		    }

		    public void setTestId(int testId) {
		        this.testId = testId;
		    }

		    public int getCatId() {
		        return catId;
		    }

		    public void setCatId(int catId) {
		        this.catId = catId;
		    }

		    public int getTotalQ() {
		        return totalQ;
		    }

		    public void setTotalQ(int totalQ) {
		        this.totalQ = totalQ;
		    }

		    public int getCorrectAns() {
		        return correctAns;
		    }

		    public void setCorrectAns(int correctAns) {
		        this.correctAns = correctAns;
		    }

		    public int getWrongAns() {
		        return wrongAns;
		    }

		    public void setWrongAns(int wrongAns) {
		        this.wrongAns = wrongAns;
		    }

		    public String getEmail() {
		        return email;
		    }

		    public void setEmail(String email) {
		        this.email = email;
		    }
		}



