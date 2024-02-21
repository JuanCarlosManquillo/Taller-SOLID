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
public interface ICategoryRepository {
    void connect();
    void disconnect();
    boolean save(Category newCategory);
    List<Category> findAll();
    boolean edit(Long id, Category category);
    boolean delete(Long id);
    Category findById(Long id);
    Category findByName(String name);
}
