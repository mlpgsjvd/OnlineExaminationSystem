package com.exammanagement.model;
import javax.persistence.*;

@Entity
@Table(name = "testdata")

public class Testdata {
	
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name = "testdataid")
		    private int testdataid;

		    @Column(name = "qid")
		    private int qid;

		    @Column(name = "answer")
		    private String answer;

		    @Column(name = "email")
		    private String email;

		    @Column(name = "testid")
		    private int testid;

		    // Getters and setters
		    public int getTestdataid() {
		        return testdataid;
		    }

		    public void setTestdataid(int testdataid) {
		        this.testdataid = testdataid;
		    }

		    public int getQid() {
		        return qid;
		    }

		    public void setQid(int qid) {
		        this.qid = qid;
		    }

		    public String getAnswer() {
		        return answer;
		    }

		    public void setAnswer(String answer) {
		        this.answer = answer;
		    }

		    public String getEmail() {
		        return email;
		    }

		    public void setEmail(String email) {
		        this.email = email;
		    }

		    public int getTestid() {
		        return testid;
		    }

		    public void setTestid(int testid) {
		        this.testid = testid;
		    }
		}




