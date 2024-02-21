
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.service.CategoryRepository;
import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ICategoryRepository;
import co.com.hyunseda.market.service.ICategoryService;
import co.com.hyunseda.market.service.IProductRepository;
import co.com.hyunseda.market.service.IProductService;
import co.com.hyunseda.market.service.ProductRepository;
import co.com.hyunseda.market.service.ProductService;

/**
 *
 * @author Libardo Pantoja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        IProductRepository repository = new ProductRepository();
        IProductService productService = new ProductService(repository);
        GUIProducts instance = new GUIProducts(productService);
        instance.setVisible(true);
        */

        ICategoryRepository repository = new CategoryRepository();
        ICategoryService categoryService = new CategoryService(repository);
        GUICategory instance = new GUICategory(categoryService);
        instance.setVisible(true);

    }
    
}
