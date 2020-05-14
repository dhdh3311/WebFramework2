package testHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table (name="product")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="product_id")
	private int id; 
	
	private String name;
	
	private int price;
	
	private String description;
	
}
