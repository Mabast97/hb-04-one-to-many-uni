package hibernate.demo;

import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {

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
            int theId = 1;

            //start a transaction
            session.beginTransaction();

            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("Found Instructor : "+ tempInstructor);

            if( tempInstructor != null )
            {
                System.out.println("Delete : "+ tempInstructor);

                session.delete(tempInstructor);
            }

            if (tempInstructor == null)
                System.out.println("There is not have this data !");

            //commit the transaction
            session.getTransaction().commit();


            System.out.println("Done ..!!!.. ");
        }
        finally {
            factory.close();
        }

    }

}
