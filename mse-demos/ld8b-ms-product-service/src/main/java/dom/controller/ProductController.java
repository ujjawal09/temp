package dom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dom.model.Product;

//annotations provide metadata
@RestController
@RequestMapping("/rest")
public class ProductController {
	@Autowired
	Environment environment;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		List<Product> productsList = new ArrayList<Product>();
		productsList.add(new Product("P01", "Power of Now."));
		productsList.add(new Product("P02", "Start with Why."));
		productsList.add(new Product("Port", environment.getProperty("local.server.port")));
		System.out.println("Products : " + productsList);
		return productsList;
	}

}
