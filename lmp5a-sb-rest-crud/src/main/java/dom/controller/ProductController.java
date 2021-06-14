package dom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dom.model.Product;
import dom.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping("/products")
	   public List<Product> getAllProducts() {
	      List<Product> productsList = productRepository.findAll();
	      return productsList;
	}

//	@PostMapping("saveProduct")
//	public String saveProduct(@ModelAttribute("product") Product product, Model model) {
//		productRepository.saveProduct(product);
//		model.addAttribute("productsListUI", productRepository.getProductsList());
//		return "index";
//	}
}
