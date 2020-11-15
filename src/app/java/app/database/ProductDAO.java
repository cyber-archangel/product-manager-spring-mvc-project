package app.database;

import java.util.List;

import app.model.*;

public interface ProductDAO {

    List<Product> getSearchResult(String keyword);

    List<Product> getProductList();

    Product getProductById(int id);

    void save(Product product);

    void delete(Product product);
}