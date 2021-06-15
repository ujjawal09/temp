package dom.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dom.model.Product;
import dom.repository.ProductRepository;

@Controller
@RequestMapping("/")
public class ProductController {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//	Product product = (Product) applicationContext.getBean("product");
	ProductRepository productRepository = (ProductRepository)applicationContext.getBean("productRepository");
	
	
	@GetMapping
	public String getAllProducts(Model model) {
		model.addAttribute("productsListUI", productRepository.getProductsList());
		return "index";
	}
	
	@PostMapping("saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product, Model model) {
		productRepository.saveProduct(product);
		model.addAttribute("productsListUI", productRepository.getProductsList());
		return "index";
	}
}
