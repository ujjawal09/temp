package dom;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import dom.model.Product;

//@FeignClient(name = "product-service", url = "http://localhost:7070")
@FeignClient(name = "zuul")
@RibbonClient("product-service")
public interface ProductServiceProxy {
	@GetMapping("product-service/rest/products")
	Product[] getAllProducts();
}
