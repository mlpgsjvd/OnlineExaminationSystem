package com.exammanagement.dao;

import com.exammanagement.model.UserRegistration;
import com.exammanagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserRegistrationDao {

	    // Save a new user
	    public void saveUser(UserRegistration user) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(user);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    // Get user by email (modified to handle non-unique results)
	    public UserRegistration getUserByEmail(String email) {
	        UserRegistration user = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            String hql = "FROM UserRegistration WHERE email = :email";
	            Query<UserRegistration> query = session.createQuery(hql, UserRegistration.class);
	            query.setParameter("email", email);

	            List<UserRegistration> users = query.getResultList(); // To handle non-unique results
	            if (!users.isEmpty()) {
	                user = users.get(0); // Assuming you need the first match
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return user;
	    }

	    // Get all users
	    public List<UserRegistration> getAllUsers() {
	        List<UserRegistration> users = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            String hql = "FROM UserRegistration";
	            Query<UserRegistration> query = session.createQuery(hql, UserRegistration.class);
	            users = query.getResultList(); // Use getResultList() instead of list()
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return users;
	    }

	    // Delete user by ID
	    public void deleteUser(int userId) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            UserRegistration user = session.get(UserRegistration.class, userId);
	            if (user != null) {
	                session.delete(user);
	            }
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    // Authenticate admin credentials (added for AdminLoginS)
	    public boolean authenticateAdmin(String email, String password) {
	        boolean isAuthenticated = false;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            String hql = "FROM UserRegistration WHERE email = :email AND password = :password AND usertype = 'Admin'";
	            Query<UserRegistration> query = session.createQuery(hql, UserRegistration.class);
	            query.setParameter("email", email);
	            query.setParameter("password", password);

	            isAuthenticated = query.uniqueResult() != null; // Check if a matching user exists
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return isAuthenticated;
	    }
	}
