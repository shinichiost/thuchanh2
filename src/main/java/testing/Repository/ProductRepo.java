package testing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import testing.Model.Product;

public interface ProductRepo extends JpaRepository<Product, String> {
	
}
