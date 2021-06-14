package dom.repository;

import java.util.ArrayList;
import java.util.List;

import dom.model.Product;

public class ProductRepository {
// An ArrayList Stub
	private List<Product> productsList;

	public ProductRepository() {
		super();
		productsList = new ArrayList<>();
		productsList.add(new Product("P01", "Man's Search For Meaning", 100));
		productsList.add(new Product("P02", "SWY", 100));
	}

	public List<Product> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}

	public void saveProduct(Product product) {
		productsList.add(product);
	}

//	delete Product
}
