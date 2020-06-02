package main;

import model.Category;
import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    //private static Logger logger = LoggerFactory.getLogger(main.Main.class);
    private static SessionFactory sessionFactory;

    public static void main(String [] args){

        sessionFactory = new Configuration().configure().buildSessionFactory();

        Category category1 = new Category();
        category1.setName("Computer");

        Category category2 = new Category();
        category2.setName("Car");

        Product product1 = new Product();
        product1.setName("Mac book Pro 16인치");
        product1.setPrice(1000);
        product1.setDescription("powerful notebook");
        product1.setCategory(category1);

        //bidirection
        category1.getProducts().add(product1);

        Product product2 = new Product();
        product2.setName("XC40");
        product2.setPrice(1000000);
        product2.setDescription("powerful suv from Volvo, my dream car");
        product2.setCategory(category2);

        //bidirection
        category2.getProducts().add(product2);

        Product product3 = new Product();
        product3.setName("CLA 220d");
        product3.setPrice(1000000);
        product3.setDescription("powerful car from Benz");
        product3.setCategory(category2);

        //bidirection
        category2.getProducts().add(product3);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(category1);
        session.save(category2);

        tx.commit();
        session.close();
    }
}
