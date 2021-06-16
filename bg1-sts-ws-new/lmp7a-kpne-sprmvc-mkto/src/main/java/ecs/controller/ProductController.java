package ecs.controller;

import ecs.model.Product;
import ecs.repo.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
//@RequestMapping("/")
public class ProductController {
	ApplicationContext applicationContext;
	Product product;
	ProductRepository productRepository;
	public ProductController(){
		applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		productRepository = (ProductRepository)applicationContext.getBean("productRepository");
	}
//@Autowired
//	ProductRepository productRepository;
//	@GetMapping(value = "/")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String findAllProducts(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		model.addAttribute("products", this.productRepository.findAllProducts());

		return "index";
	}
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String findAllProducts(Model model) {
		model.addAttribute("products", this.productRepository.findAllProducts());
		return "index";
	}
	@RequestMapping("/saveProduct")
	public String saveProduct(ModelMap model, @RequestParam Integer productId, @RequestParam String productName,
						   @RequestParam Float price, @RequestParam String available) {
		model.addAttribute("products", productRepository.findAllProducts());
		if (productId == null || productName.isEmpty() || price == null || available.isEmpty()) {
			model.addAttribute("errors", "Please fill the required fields");
			return "index";
		} else if (productRepository.exists(productId)) {
			model.addAttribute("errors", "Product ID already exists");
			return "index";
		} else {
//			Product product = new Product();
			product = (Product) applicationContext.getBean("product");
			product.setProductId(productId);
			product.setProductName(productName);
			product.setPrice(price);
			product.setAvailable(available);
			this.productRepository.addProduct(product);
		}
		model.addAttribute("products", productRepository.findAllProducts());

		return "redirect:/";
//		return "index";
	}
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public String deleteProduct(ModelMap model, @RequestParam("productId") int productId) {
		this.productRepository.deleteProduct(productId);
		model.addAttribute("products", this.productRepository.findAllProducts());
		return "redirect:/";
//		return "index";
	}
}
