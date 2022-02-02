package hibernate.demo;

import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailWithoutInstructorDemo {

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
            int detailId = 12;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, detailId);
            System.out.println("DELETE : " + tempInstructorDetail.getYoutubeChannel());
            tempInstructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(tempInstructorDetail);

//            Instructor tempInstructor = new Instructor("Fifth", "Fifty", "s55@gmail.com");
//            InstructorDetail tempInstructorDetail = new InstructorDetail("www.Fifth.com", "Hello");
//            tempInstructor.setInstructorDetail(tempInstructorDetail);
//            session.save(tempInstructor);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done ..!!!.. ");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            factory.close();
            session.close();
        }

    }

}
