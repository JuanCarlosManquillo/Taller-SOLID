/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.hyunseda.market.service;

import java.util.List;

/**
 *
 * @author Juan
 */
public interface IProductService {
    public boolean saveProduct(String name, String description);
    public List<Product> findAllProducts();
    public boolean editProduct(Long productId, Product prod);
    public Product findProductById(Long id);
    public Product findProductByName(String name);
    public boolean deleteProduct(Long id);
    
}
