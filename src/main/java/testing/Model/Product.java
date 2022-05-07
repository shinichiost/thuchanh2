package testing.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Product {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column
	private String description;
	@Column
	private float price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Product(String description, float price) {
		this.description = description;
		this.price = price;
	}
	public Product() {
	}
	
	
	
	
}
