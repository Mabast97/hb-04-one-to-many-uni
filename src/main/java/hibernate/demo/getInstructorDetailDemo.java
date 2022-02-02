package hibernate.demo;

import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class getInstructorDetailDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();
//
            // get the instructor detail object
            int theId = 2;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            // print the instructor detail
            System.out.println("First Name : "+tempInstructorDetail.getInstructor().getFirstName());
            System.out.println("Second Name : "+tempInstructorDetail.getInstructor().getLastName());

            // print the associated instructor

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done ..!!!.. ");
        }
        finally {
            factory.close();
            session.close();
        }

    }

}
