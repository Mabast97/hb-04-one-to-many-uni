package hibernate.demo;

import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

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
            // create the objects
            /*
            Instructor tempInstructor = new Instructor("First", "First11", "f1@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.hi.com", "Love to learn");
            */


            Instructor tempInstructor = new Instructor("Third", "Third33", "s33@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.Third.com", "Aweful");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start a transaction
            session.beginTransaction();

            // save the instructor
            // Note: this will ALSO save the details object because of Cascade.All
            System.out.println("Saving instructor : "+tempInstructor);
            session.save(tempInstructor);


            //commit the transaction
            session.getTransaction().commit();


            System.out.println("Done ..!!!.. ");
        }
        finally {
            factory.close();
        }

    }

}
