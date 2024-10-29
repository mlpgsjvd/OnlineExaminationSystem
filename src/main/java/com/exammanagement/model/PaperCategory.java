package com.exammanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "papercat")

public class PaperCategory {
	
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name = "catid")
		    private int catId;

		    @Column(name = "catname")
		    private String catName;

		    @Column(name = "catdetail")
		    private String catDetail;

		    // Getters and Setters
		    public int getCatId() {
		        return catId;
		    }

		    public void setCatId(int catId) {
		        this.catId = catId;
		    }

		    public String getCatName() {
		        return catName;
		    }

		    public void setCatName(String catName) {
		        this.catName = catName;
		    }

		    public String getCatDetail() {
		        return catDetail;
		    }

		    public void setCatDetail(String catDetail) {
		        this.catDetail = catDetail;
		    }
		}


