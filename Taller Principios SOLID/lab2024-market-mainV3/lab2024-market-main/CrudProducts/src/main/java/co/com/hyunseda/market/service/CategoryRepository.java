/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class CategoryRepository implements ICategoryRepository{
    private Connection conn;
    
    public CategoryRepository() {initDatabase();}
    
    public void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS category (\n"
                +"	category_id integer PRIMARY KEY AUTOINCREMENT,\n"
                +"	name TEXT NOT NULL\n"
                +");";
        try{
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        }catch(SQLException ex){
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    public void connect() {
        String url = "jdbc:sqlite::memory:";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Metodo para desconectar la base de datos
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
    public boolean saveCategory(long categoryId, String name) {
        Category newCategory = new Category();
        newCategory.setCategoryId(categoryId);
        newCategory.setName(name);
        if (newCategory.getName().isEmpty()) {
            return false;
        }
        return save(newCategory);
    }
*/
    //Metodo para guardar una categoria
    @Override
    public boolean save(Category newCategory) {
        try {
            //Validate category
            if (newCategory == null || newCategory.getName().isEmpty()) {
                return false;
            }
            
            String sql = "INSERT INTO category (name)"
                    +"VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newCategory.getName());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null,ex);
        }
        return false;
    }
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {

            String sql = "SELECT * FROM category";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Category newCategory = new Category();
                newCategory.setCategoryId(rs.getLong("category_id"));
                newCategory.setName(rs.getString("name"));

                categories.add(newCategory);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
    
    @Override
    public boolean edit(Long id, Category category) {
        try {
            //Validate product
            if (id <= 0 || category == null) {
                return false;
            }
            //this.connect();

            String sql = "UPDATE  category "
                    + "SET name=?"
                    + "WHERE category_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category.getName());
            pstmt.setLong(2, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean delete(Long id) {
        try {
            //Validate product
            if (id <= 0) {
                return false;
            }
            //this.connect();

            String sql = "DELETE FROM category "
                    + "WHERE category_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public Category findById(Long id) {
        try {

            String sql = "SELECT * FROM category  "
                    + "WHERE category_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Category category = new Category();
                category.setCategoryId(res.getLong("category_id"));
                category.setName(res.getString("name")); 
                return category;
                
            } else {
                return null;
            }
            //this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Category findByName(String name) {
        try {

            String sql = "SELECT * FROM category "
                    + "WHERE name = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Category category = new Category();
                category.setCategoryId(res.getLong("category_id"));
                category.setName(res.getString("name"));
                return category;
            } else {
                return null;
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    
}
