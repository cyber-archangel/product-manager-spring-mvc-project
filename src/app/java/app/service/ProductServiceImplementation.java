package app.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import app.database.*;
import app.model.*;

@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductDAO productDataAccessObject;

    @Autowired
    public ProductServiceImplementation(ProductDAO productDataAccessObject) {
        this.productDataAccessObject = productDataAccessObject;
    }

    @Override
    @Transactional
    public List<Product> getSearchResult(String keyword) {
        return productDataAccessObject.getSearchResult(keyword);
    }

    @Override
    @Transactional
    public List<Product> getProductList() {
        return productDataAccessObject.getProductList();
    }

    @Override
    @Transactional
    public Product getProductById(int id) {
        return productDataAccessObject.getProductById(id);
    }

    @Override
    @Transactional
    public void save(Product product) {
        productDataAccessObject.save(product);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        productDataAccessObject.delete(product);
    }
}