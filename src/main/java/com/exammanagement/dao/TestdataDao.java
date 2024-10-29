package com.exammanagement.dao;

import com.exammanagement.model.Testdata;
import com.exammanagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TestdataDao {

	    private SessionFactory sessionFactory;

	    public TestdataDao() {
	        this.sessionFactory = HibernateUtil.getSessionFactory();
	    }

	    public int insertData(Testdata testdata) {
	        Transaction transaction = null;
	        int testdataId = 0;
	        try (Session session = sessionFactory.openSession()) {
	            transaction = session.beginTransaction();
	            testdataId = (int) session.save(testdata);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        }
	        return testdataId;
	    }

	    public List<Testdata> displayByTestID(int testid) {
	        List<Testdata> result = null;
	        try (Session session = sessionFactory.openSession()) {
	            result = session.createQuery("FROM Testdata WHERE testid = :testid", Testdata.class)
	                    .setParameter("testid", testid)
	                    .list();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }

	    public int ansCount(Testdata testdata) {
	        int count = 0;
	        try (Session session = sessionFactory.openSession()) {
	            count = session.createQuery("SELECT COUNT(t) FROM Testdata t WHERE t.qid = :qid AND t.answer = :answer", Long.class)
	                    .setParameter("qid", testdata.getQid())
	                    .setParameter("answer", testdata.getAnswer())
	                    .uniqueResult().intValue();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return count;
	    }

	    public void close() {
	        if (sessionFactory != null && !sessionFactory.isClosed()) {
	            sessionFactory.close();
	        }
	    }
	}

}