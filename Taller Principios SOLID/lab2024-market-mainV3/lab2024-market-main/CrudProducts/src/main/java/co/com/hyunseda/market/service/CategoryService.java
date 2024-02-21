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
public class CategoryService implements ICategoryService{
    private ICategoryRepository repository;
    
    public CategoryService(ICategoryRepository repository){
        this.repository=repository;
    }
    
    public boolean saveCategory(String name) {
        Category newCategory = new Category();
        newCategory.setName(name);
        if (newCategory.getName().isEmpty()) {
            return false;
        }
        return repository.save(newCategory);
    }
    
    public List<Category> findAllCategories() {
        List<Category> categories = new ArrayList<>();
        categories = repository.findAll();
        return categories;
    }
    
    public boolean editCategory(Long categoryID, Category category) {

        //Validate category
        if (category == null || category.getName().isEmpty()) {
            return false;
        }
        return repository.edit(categoryID, category);
    }
    
    public Category findCategoryById(Long id) {
        return repository.findById(id);
    }
    public Category findCategoryByName(String name) {
        return repository.findByName(name);
    }
    public boolean deleteCategory(Long id) {
        if (id == null || id <= 0) {
            return false;
        }
        return repository.delete(id);
    }
    
}
