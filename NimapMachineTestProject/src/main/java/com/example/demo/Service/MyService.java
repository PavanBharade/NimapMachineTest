package com.example.demo.Service;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.CategoryRepository;
import com.example.demo.Repository.ProductRepository;

@Service
public class MyService {
@Autowired
ProductRepository productR;
@Autowired
CategoryRepository categoryR;
public String SaveAlldata(Category C)
{
	for(Product P: C.getProducts())
	{
		P.setCategory(C); // add category_id in product table
	}
	categoryR.save(C);
	return "DATA ADDED SUCCESSFULLY";
}

public Page<Category> SaveAlldata(Pageable pageable)
{
	
	return categoryR.findAll(pageable);
}
public String saveProduct(int categoryId, Product product) {
    Category category = categoryR.findById(categoryId).orElse(null);
    if (category == null) {
        return "Category with ID " + categoryId + " not found!";
    }

    product.setCategory(category);     // Link product to the category

    productR.save(product);             // Save the product to the database
    return "Product added successfully!";
}
//GET category by Id
public Category findbyid(int c) {
	return categoryR.findById(c) .orElse(null);
}

//update category by id
public String update(int id, Category s1)
{
	Category s2 = categoryR.findById(id).orElse(null);
	if(s1.getCname() != null)
		s2.setCname(s1.getCname());
	categoryR.save(s2);
	return "update successfull";
}
//Delete category by id
public String deletebyid(int id)
{
	if(categoryR.existsById(id))
	{
		categoryR.deleteById(id);
		return "Data Deleted By Id";
	}
	else
	return "Data Not Found By Id";
}


//GET product by Id
public Product findProductByid(int p) {
	return productR.findById(p) .orElse(null);
}

public Page<Product> getAllProducts(Pageable pageable) {
    return productR.findAll(pageable);
}

//Delete product by id
public String deleteProductByid(int id)
{
	if(productR.existsById(id))
	{
		productR.deleteById(id);
		return "Product Data Deleted By Id";
	}
	else
	return " Product Data Not Found ";
}


//update product by id
public String updateProductByid(int id, Product p1)
{
	Product p2 = productR.findById(id).orElse(null);
	if(p1.getPname() != null)
		p2.setPname(p1.getPname());
	if(p1.getPrice()!=null)
		p2.setPrice(p1.getPrice());
	productR.save(p2);
	return "update successfull";
}

}
