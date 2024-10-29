package com.exammanagement.dao;

import com.exammanagement.model.QuestionPaper;
import com.exammanagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionPaperDao {
	
		    
		    public void insertData(QuestionPaper questionPaper) {
		        Transaction transaction = null;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            transaction = session.beginTransaction();
		            session.save(questionPaper);
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) transaction.rollback();
		            e.printStackTrace();
		        }
		    }

		    public QuestionPaper displayByID(int qid) {
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            return session.get(QuestionPaper.class, qid);
		        }
		    }

		    public List<QuestionPaper> displayByCatID(int cid) {
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            Query<QuestionPaper> query = session.createQuery("FROM QuestionPaper WHERE catid = :catid", QuestionPaper.class);
		            query.setParameter("catid", cid);
		            return query.list();
		        }
		    }

		    public List<QuestionPaper> displayAll() {
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            return session.createQuery("FROM QuestionPaper", QuestionPaper.class).list();
		        }
		    }

		    public void deleteDataByID(int qid) {
		        Transaction transaction = null;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            transaction = session.beginTransaction();
		            QuestionPaper questionPaper = session.get(QuestionPaper.class, qid);
		            if (questionPaper != null) {
		                session.delete(questionPaper);
		            }
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) transaction.rollback();
		            e.printStackTrace();
		        }
		    }

		    public void deleteAllData() {
		        Transaction transaction = null;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            transaction = session.beginTransaction();
		            session.createQuery("DELETE FROM QuestionPaper").executeUpdate();
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) transaction.rollback();
		            e.printStackTrace();
		        }
		    }

		    public void updateDataByID(QuestionPaper questionPaper) {
		        Transaction transaction = null;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            transaction = session.beginTransaction();
		            session.update(questionPaper);
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) transaction.rollback();
		            e.printStackTrace();
		        }
		    }
		}
