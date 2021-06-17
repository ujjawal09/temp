package dom;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import dom.model.Product;

@FeignClient(name = "product-service", url = "http://localhost:7070")
public interface ProductServiceProxy {
	@GetMapping("/rest/products")
	Product[] getAllProducts();
}
