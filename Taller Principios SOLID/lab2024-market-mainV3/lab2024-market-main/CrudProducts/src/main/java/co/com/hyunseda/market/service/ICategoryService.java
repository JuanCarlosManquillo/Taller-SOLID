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
public interface ICategoryService {
    boolean saveCategory(String name);
    List<Category> findAllCategories();
    boolean editCategory(Long categoryID, Category category);
    Category findCategoryById(Long id);
    Category findCategoryByName(String name);
    boolean deleteCategory(Long id);
}
