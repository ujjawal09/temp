package dom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private Long productId;
	   @Column(name = "PRODUCT_NAME", nullable = false)
	   private String productName;
	   @Column(name = "PRICE", nullable = false)
	   private float price;
}
