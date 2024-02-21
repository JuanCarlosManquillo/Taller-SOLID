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
public interface IProductRepository {
    Product findById(Long id);
    boolean save(Product newProduct);
    List<Product> findAll();
    void connect();
    void disconnect();
    boolean edit(Long id, Product product);
    boolean delete(Long id);
    Product findByName(String name);
    
}
