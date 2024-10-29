package com.exammanagement.dao;

import com.exammanagement.model.Testr;
import com.exammanagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestrDao {

	    // Insert Testr
	    public int insertData(Testr testr) {
	        Transaction transaction = null;
	        int id = 0;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(testr);
	            transaction.commit();
	            id = testr.getCatid();  // Get the inserted ID after commit
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return id;
	    }
	}

