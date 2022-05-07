package testing.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import testing.Model.Product;
import testing.Repository.ProductRepo;
@Slf4j
@Controller
@RequestMapping("/productMaint1")
public class ProductController {
	@Autowired
	private ProductRepo productRepo;
	private Product tmp;
	@GetMapping()
	public String home() {
		return "homepage";
	}
	
	@GetMapping("/displayProducts")
	public String displayProducts(Model model) {
		model.addAttribute("productlist", productRepo.findAll());
		return "displayProducts";
	}
	
	@GetMapping("/updateProduct")
	public String updateProduct(@RequestParam(name="id") String id, Model model) {
		model.addAttribute("product",productRepo.findById(id));
		tmp = productRepo.findById(id).get();
		return "updateProduct";
	
	}
	
	@PostMapping("/updateProduct")
	public String updateDB(@ModelAttribute("product") Product product, Errors errors) {
		if(errors.hasErrors()) {
			return "updateProduct";
		}
		productRepo.deleteById(tmp.getId());
		productRepo.save(product);
		return"redirect:displayProducts";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam(name="id" )String id, Model model) {
		Product product = productRepo.findById(id).get();
		model.addAttribute("product", product);
		return "delete";
	}
	@PostMapping("/deleteProduct")
	public String deleteinDB(Product product) {
		productRepo.deleteById(product.getId());
		return "redirect:displayProducts";
	}

	@GetMapping("/addProduct")
	public String addProduct(Model model) {
		
		model.addAttribute("product", new Product());
		
		return "addProduct";
	}
	
	@PostMapping("/addProduct")
	public String updateRepo(Product product, Errors errors) {
		if(errors.hasErrors()) {
			log.info(errors.toString());
			
			return "addProduct";
		}
		productRepo.save(product);
		return "redirect:displayProducts";
	}
	
	
	
	
}
