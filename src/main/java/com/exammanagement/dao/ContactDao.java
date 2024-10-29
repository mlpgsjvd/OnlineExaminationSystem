package com.exammanagement.dao;

import com.exammanagement.model.Contact;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.exammanagement.util.HibernateUtil;

public class ContactDao {
	

	    // Save contact
	    public void saveContact(Contact contact) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(contact);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    // Add more methods if needed
	}

