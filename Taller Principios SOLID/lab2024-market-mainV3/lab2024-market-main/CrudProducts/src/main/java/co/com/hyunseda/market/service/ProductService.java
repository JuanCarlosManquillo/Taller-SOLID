/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class ProductService implements IProductService{
    private IProductRepository repository;
    
    public ProductService(IProductRepository repository){
        this.repository=repository;
    }
    
    public boolean saveProduct(String name, String description) {
        Product newProduct= new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        if (newProduct.getName().isEmpty() ) {
            return false;
        }
        return repository.save(newProduct);
    }
   
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.findAll();
        return products;
    }
    
    public boolean editProduct(Long productId, Product prod) {

        //Validate product
        if (prod == null || prod.getName().isEmpty()) {
            return false;
        }
        return repository.edit(productId, prod);
    }
        
    
    public Product findProductById(Long id){
        return repository.findById(id);
    }
    
    public Product findProductByName(String name){
        return repository.findByName(name);
    }
          // TO DO
      public boolean deleteProduct(Long id){
        if (id==null || id<=0) {
            return false;
        }
        return repository.delete(id);
    }
   
    
    
}
