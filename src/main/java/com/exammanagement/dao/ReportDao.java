package com.exammanagement.dao;

import com.exammanagement.model.Report;
import com.exammanagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReportDao {

		
		    public int insertReport(Report report) {
		        Transaction transaction = null;
		        int result = 0;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            transaction = session.beginTransaction();
		            result = (int) session.save(report);
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) {
		                transaction.rollback();
		            }
		            e.printStackTrace();
		        }
		        return result;
		    }

		    public List<Report> showAllReportsByEmail(String email) {
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            String hql = "FROM Report WHERE email = :email ORDER BY reportId DESC";
		            Query<Report> query = session.createQuery(hql, Report.class);
		            query.setParameter("email", email);
		            return query.list();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return null;
		    }

		    public Report showAllReportsByReportId(int reportId) {
		        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
						Session session = sessionFactory.openSession()) {
		            return session.get(Report.class, reportId);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return null;
		    }
		}


