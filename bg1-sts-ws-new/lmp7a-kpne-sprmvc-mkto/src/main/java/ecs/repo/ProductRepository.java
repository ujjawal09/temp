package ecs.repo;

import ecs.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    List<Product> productList;

    public ProductRepository(){
    this.productList = new ArrayList<>();
    }


    public   List<Product> findAllProducts() {
        return this.productList;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }
    public boolean deleteProduct(int productId) {
        List<Product> deletedProductList = this.productList.stream().filter(product -> product.getProductId() != productId).collect(Collectors.toList());
        if(this.productList.size() == deletedProductList.size()){
            return false;
        }else
        {
            this.productList = deletedProductList;
            return true;
        }
    }
    public boolean exists(Integer productId) {
        List<Product> existsProductList = this.productList.stream().filter(product -> product.getProductId() != productId).collect(Collectors.toList());
        if(this.productList.size() == existsProductList.size()){
//            System.out.println("Product not found : " + productId);
            return false;
        }else
        {
            return true;
        }
    }


}
