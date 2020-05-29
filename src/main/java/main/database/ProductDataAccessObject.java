package main.database;

import org.springframework.stereotype.Component;
import org.hibernate.*;
import javax.persistence.TypedQuery;
import java.util.List;
import main.utils.*;
import main.models.*;

@Component
public class ProductDataAccessObject {

    private Session session;

    private Transaction transaction;

    public List<Product> getSearchResult(String keyword) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        TypedQuery<Product> query = session.createQuery("from Product where name like concat('%', :keyword, '%')", Product.class);
        query.setParameter("keyword", keyword);
        List<Product> products = query.getResultList();
        session.close();
        return products;
    }

    public List<Product> getProductList() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Product> products = session.createQuery("from Product", Product.class).list();
        session.close();
        return products;
    }

    public Product getProductById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
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
}