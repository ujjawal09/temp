package ecs.repo;

import ecs.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
//    List<Product> productList;

    @Autowired
    private SessionFactory sessionFactory;

    public ProductRepositoryImpl(SessionFactory sessionFactory) {

        this.sessionFactory= sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    public List<Product> findAllProducts() {

        List<Product>  products = (List<Product>) getSession().createQuery("from Product").getResultList();
        return products;
    }

    public void addProduct(Product product) {
        getSession().save(product);
    }

    public boolean deleteProduct(int productId) {

        Product product = getProductById(productId);
        if(product!= null) {
            getSession().delete(product);;

            return true;
        }
        return false;
    }

    public boolean exists(Integer productId) {
        Product product = getProductById(productId);
        if(product!= null) {
            getSession().delete(product);;

            return true;
        }
        return false;
    }
    public Product getProductById(int productId) {

        Query query = getSession().createQuery("from Product where productId=?1");

        query.setParameter(1, productId);

        Product product = (Product) query.getSingleResult();
        return product;

    }

}

