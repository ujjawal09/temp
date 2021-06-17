package dom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dom.ProductServiceProxy;
import dom.model.Product;

//annotations provide metadata
@RestController
@RequestMapping("/rest")
public class ProductController {
// using FeignClient and Proxy
	@Autowired
	private ProductServiceProxy proxy;

	@GetMapping("/products")
	public Product[] getAllProducts() {
		System.out.println("******** USING FEIGN CLIENT **********");
		Product[] products = proxy.getAllProducts();
		return products;
	}

//	using RESTTemplate to fetch data from product-service	
//	@Autowired
//	private RestTemplate restTemplate;
//	@GetMapping("/products")
//	public Product[] getAllProducts() {
//		//Fetch data from the RESTful service
//		String url = "http://localhost:8071/rest/products";
//		ResponseEntity<Product[]> responseEntity = restTemplate.getForEntity(url, Product[].class);
//		Product[] products = responseEntity.getBody();
//		return products;
//	}

}
