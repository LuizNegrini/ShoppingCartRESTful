package dao;

import bases.BaseDAO;
import domain.Product;

public class ProductDAO extends BaseDAO<Product> {
    public ProductDAO() {
        super(Product.class);
    }
}
