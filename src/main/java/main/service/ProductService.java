package main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import main.database.*;
import main.models.*;

@Service
public class ProductService {

    private final ProductDataAccessObject productDataAccessObject;

    @Autowired
    public ProductService(ProductDataAccessObject productDataAccessObject) {
        this.productDataAccessObject = productDataAccessObject;
    }

    public List<Product> getProductList() {
        return productDataAccessObject.getProductList();
    }

    public void save(Product product) {
        productDataAccessObject.save(product);
    }

    public void delete(Product product) {
        productDataAccessObject.delete(product);
    }

    public void update(Product product) {
        productDataAccessObject.update(product);
    }
}