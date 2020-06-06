package main.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.transaction.Transactional;
import java.util.List;
import main.database.*;
import main.models.*;

@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductDataAccessObject productDataAccessObject;

    @Autowired
    public ProductServiceImplementation(ProductDataAccessObject productDataAccessObject) {
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
