package dom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dom.model.Product;
import dom.repository.ProductRepository;

@RestController
@RequestMapping("/duplicate-api")
public class DuplicateProductController {

	@Autowired
	ProductRepository productRepository;

//	Get all products
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		List<Product> productsList = productRepository.findAll();
		return productsList;
	}

// get product by id
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable(value = "id") Long productId) {
		Optional<Product> productOptional = productRepository.findById(productId);
		Product product = productOptional.get();
		return product;
	}

// create new product
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		Product product1 = productRepository.save(product);
		return product1;
	}

	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable(value = "id") Long productId, @RequestBody Product product) {
		Product product1 = productRepository.findById(productId).get();
		product1.setProductName(product.getProductName());
		product1.setPrice(product.getPrice());
		Product product2 = productRepository.save(product1);
		return product2;
	}

	// get product by id
	@DeleteMapping("/products/{id}")
	public boolean deleteProduct(@PathVariable(value = "id") Long productId) {
		productRepository.deleteById(productId);
		return true;
	}
//	@PostMapping("saveProduct")
//	public String saveProduct(@ModelAttribute("product") Product product, Model model) {
//		productRepository.saveProduct(product);
//		model.addAttribute("productsListUI", productRepository.getProductsList());
//		return "index";
//	}
}
