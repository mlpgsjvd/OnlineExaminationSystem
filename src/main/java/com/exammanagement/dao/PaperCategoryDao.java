package com.exammanagement.dao;

import com.exammanagement.model.PaperCategory;
import com.exammanagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PaperCategoryDao {

	    // Insert a new PaperCategory
	    public int insertPaperCategory(PaperCategory paperCategory) {
	        Transaction transaction = null;
	        int result = 0;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(paperCategory);
	            transaction.commit();
	            result = 1; // Assuming the insert is successful, return 1
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return result;
	    }

	    // Show all paper categories
	    public List<PaperCategory> showAllPaperCategory() {
	        List<PaperCategory> paperCategories = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            String hql = "FROM PaperCategory";  // Corrected the entity name here
	            Query<PaperCategory> query = session.createQuery(hql, PaperCategory.class);
	            paperCategories = query.list();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return paperCategories;
	    }

	    // Get PaperCategory name by ID
	    public String paperCategoryById(int id) {
	        String paperName = "";
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            PaperCategory paperCategory = session.get(PaperCategory.class, id);
	            if (paperCategory != null) {
	                paperName = paperCategory.getCatName();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return paperName;
	    }
	}

