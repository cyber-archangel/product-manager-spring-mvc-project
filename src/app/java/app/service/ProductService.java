package app.service;

import java.util.List;

import app.model.*;

public interface ProductService {

    List<Product> getSearchResult(String keyword);

    List<Product> getProductList();

    Product getProductById(int id);

    void save(Product product);

    void delete(Product product);
}