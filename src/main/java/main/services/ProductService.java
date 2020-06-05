package main.services;

import java.util.List;
import main.models.*;

public interface ProductService {

    List<Product> getSearchResult(String keyword);

    List<Product> getProductList();

    Product getProductById(int id);

    void save(Product product);

    void delete(Product product);
}