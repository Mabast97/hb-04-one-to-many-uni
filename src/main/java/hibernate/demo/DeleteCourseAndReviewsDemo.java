package hibernate.demo;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {

            //start a transaction
            session.beginTransaction();

            /*
            // For Deleting the Review .
            int theId = 2;
            Review tempReview = session.get(Review.class, theId);
            System.out.println("Review : " + tempReview);
            session.delete(tempReview);
             */

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);
            System.out.println("DELETING Course : " + tempCourse);
            System.out.println("Course Reviews : " + tempCourse.getReviews());
            session.delete(tempCourse);

            //commit the transaction
            session.getTransaction().commit();


            System.out.println("Done ..!!!.. ");
        }
        finally {
            session.close();
            factory.close();
        }

    }

}
