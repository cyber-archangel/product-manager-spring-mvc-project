package main.database;

import org.springframework.stereotype.Repository;
import org.hibernate.*;
import javax.persistence.TypedQuery;
import java.util.List;
import org.slf4j.*;
import main.utils.*;
import main.models.*;

@Repository
public class ProductDataAccessObjectImplementation implements ProductDataAccessObject {

    private static final Logger logger = LoggerFactory.getLogger(ProductDataAccessObjectImplementation.class);

    @Override
    public List<Product> getSearchResult(String keyword) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        TypedQuery<Product> query = session.createQuery("from Product where name like concat('%', :keyword, '%')", Product.class);
        query.setParameter("keyword", keyword);
        List<Product> products = query.getResultList();
        session.close();
        logger.info("The search result is successfully loaded...");
        return products;
    }

    @Override
    public List<Product> getProductList() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Product> products = session.createQuery("from Product", Product.class).list();
        session.close();
        logger.info("All products is successfully loaded...");
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        logger.info("The " + product.getName() + "is successfully loaded...");
        return product;
    }

    @Override
    public void save(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
        logger.info("The " + product.getName() + "is successfully saved...");
    }

    @Override
    public void delete(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
        logger.info("The " + product.getName() + "is successfully deleted...");
    }
}