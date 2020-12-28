package app.database;

import org.springframework.stereotype.Repository;
import org.hibernate.*;
import javax.persistence.TypedQuery;
import java.util.List;
import org.slf4j.*;

import app.util.*;
import app.model.*;

@Repository
public class ProductDataAccessObjectImplementation implements ProductDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductDataAccessObjectImplementation.class);

    @Override
    public List<Product> getSearchResult(String keyword) {
        var session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        var query = session.createQuery("from Product where name like concat('%', :keyword, '%')", Product.class);
        query.setParameter("keyword", keyword);
        var products = query.getResultList();
        session.close();
        logger.info("The search result is successfully loaded...");
        return products;
    }

    @Override
    public List<Product> getProductList() {
        var session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        var products = session.createQuery("from Product", Product.class).list();
        session.close();
        logger.info("All products is successfully loaded...");
        return products;
    }

    @Override
    public Product getProductById(int id) {
        var session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        var product = session.get(Product.class, id);
        session.close();
        logger.info("The " + product.getName() + "is successfully loaded...");
        return product;
    }

    @Override
    public void save(Product product) {
        var session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
        logger.info("The " + product.getName() + "is successfully saved...");
    }

    @Override
    public void delete(Product product) {
        var session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
        logger.info("The " + product.getName() + "is successfully deleted...");
    }
}