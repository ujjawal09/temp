package dom;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import dom.model.Product;

@FeignClient(name = "product-client", url = "http://localhost:6061")
public interface ProductServiceProxy2 {
	@GetMapping("/rest/products")
	Product[] getAllProducts();
}
