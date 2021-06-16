package ecs.repo;

import ecs.model.Product;

import java.util.List;

public interface ProductRepository {
    public void addProduct(Product product);

    public boolean deleteProduct(int productId);

    public List<Product> findAllProducts();

    public boolean exists(Integer productId);

}
