package com.exammanagement;

import com.exammanagement.dao.*;
import com.exammanagement.model.*;

import java.util.List;

public class MainApp {

	    public static void main(String[] args) {
	        // Initialize DAOs
	        UserRegistrationDao userDao = new UserRegistrationDao();
	        ContactDao contactDao = new ContactDao();
	        PaperCategoryDao paperCategoryDao = new PaperCategoryDao();
	        QuestionPaperDao questionPaperDao = new QuestionPaperDao();
	        ReportDao reportDao = new ReportDao();
	        TestdataDao testdataDao = new TestdataDao();
	        TestrDao testrDao = new TestrDao();

	        try {
	            // Example 1: Creating a new User
	            UserRegistration newUser = new UserRegistration();
	            newUser.setName("John Doe");
	            newUser.setDob("1990-01-01");
	            newUser.setEmail("john.doe@example.com");
	            newUser.setPassword("password123");
	            newUser.setCity("Eluru");
	            newUser.setState("AP");
	            newUser.setUsertype("Student");

	            userDao.saveUser(newUser);  // Save new user

	            // Fetch and print user by email
	            UserRegistration fetchedUser = userDao.getUserByEmail("john.doe@example.com");
	            if (fetchedUser != null) {
	                System.out.println("User fetched by email: " + fetchedUser.getName());
	            } else {
	                System.out.println("No user found with email 'john.doe@example.com'");
	            }

	            // Example 2: Creating a new Contact
	            Contact newContact = new Contact();
	            newContact.setName("Jane Doe");
	            newContact.setEmail("jane.doe@example.com");
	            newContact.setPhone("1234567890");
	            newContact.setSubject("General Inquiry");
	            newContact.setMessage("Hello, I have a question.");

	            contactDao.saveContact(newContact);  // Save new contact
	            System.out.println("Contact saved successfully.");

	            // Example 3: Creating a new Paper Category
	            PaperCategory newCategory = new PaperCategory();
	            newCategory.setCatName("JAVA");
	            newCategory.setCatDetail("JAVA-related papers and exams");

	            int categoryId = paperCategoryDao.insertPaperCategory(newCategory);  // Save new paper category
	            System.out.println("New Paper Category saved with ID: " + categoryId);

	            // Fetch and print all Paper Categories
	            List<PaperCategory> categories = paperCategoryDao.showAllPaperCategory();
	            if (categories != null && !categories.isEmpty()) {
	                System.out.println("Available Paper Categories:");
	                for (PaperCategory category : categories) {
	                    System.out.println("ID: " + category.getCatId() + ", Name: " + category.getCatName() + ", Detail: " + category.getCatDetail());
	                }
	            } else {
	                System.out.println("No paper categories found.");
	            }

	            // Example 4: Fetch Paper Category by ID
	            String categoryName = paperCategoryDao.paperCategoryById(categoryId);
	            if (categoryName != null) {
	                System.out.println("Category with ID " + categoryId + ": " + categoryName);
	            } else {
	                System.out.println("No category found with ID " + categoryId);
	            }

	            // Example 5: Creating a new Question Paper
	            QuestionPaper newQuestion = new QuestionPaper();
	            newQuestion.setCatid(categoryId); // Set the category ID dynamically
	            newQuestion.setQuestion("What is Java?");
	            newQuestion.setOption_a("A programming language");
	            newQuestion.setOption_b("A type of coffee");
	            newQuestion.setOption_c("A kind of snake");
	            newQuestion.setOption_d("None of the above");
	            newQuestion.setAnswer("A programming language");
	            newQuestion.setStatus("Active");

	            questionPaperDao.insertData(newQuestion); // Save new question
	            System.out.println("New Question Paper added successfully.");

	            // Fetch and display all Question Papers
	            List<QuestionPaper> questionPapers = questionPaperDao.displayAll();
	            if (questionPapers != null && !questionPapers.isEmpty()) {
	                System.out.println("All Question Papers:");
	                for (QuestionPaper qp : questionPapers) {
	                    System.out.println("ID: " + qp.getQid() + ", Question: " + qp.getQuestion());
	                }
	            } else {
	                System.out.println("No Question Papers found.");
	            }

	            // Example 6: Insert new test data (TestdataDao)
	            Testdata testdata = new Testdata();
	            testdata.setQid(1);
	            testdata.setAnswer("A programming language");
	            testdata.setEmail("student@example.com");
	            testdata.setTestid(101);

	            int testdataId = testdataDao.insertData(testdata);
	            System.out.println("Test data inserted with ID: " + testdataId);

	            // Fetch and display test data by test ID
	            List<Testdata> testdataList = testdataDao.displayByTestID(101);
	            if (testdataList != null && !testdataList.isEmpty()) {
	                System.out.println("Test data for test ID 101:");
	                for (Testdata td : testdataList) {
	                    System.out.println("Testdata ID: " + td.getTestdataid() + ", QID: " + td.getQid() + ", Answer: " + td.getAnswer());
	                }
	            } else {
	                System.out.println("No test data found for test ID 101.");
	            }

	            // Example 7: Count correct answers (TestdataDao)
	            int correctAnswerCount = testdataDao.ansCount(testdata);
	            System.out.println("Correct answer count for QID " + testdata.getQid() + ": " + correctAnswerCount);

	            // Example 8: Inserting new Testr data (TestrDao)
	            Testr newTestr = new Testr();
	            newTestr.setEmail("student@example.com");
	            newTestr.setCatid(5);

	            int insertedTestrId = testrDao.insertData(newTestr);
	            System.out.println("Testr inserted with ID: " + insertedTestrId);

	        } finally {
	            // If any DAOs or sessions need explicit closure, it will be handled here.
	        }
	    }
	}

