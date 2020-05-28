package main.database;

import org.springframework.stereotype.Component;
import org.hibernate.*;
import java.util.List;
import main.utils.*;
import main.models.*;

@Component
public class ProductDataAccessObject {

    private Session session;

    private Transaction transaction;

    public List<Product> getProductList() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from main.models.Product", Product.class).list();
    }

    public void save(Product product) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    public void delete(Product product) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
    }

    public void update(Product product) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
        session.close();
    }
}