package dao;

import bases.BaseDAO;
import domain.ShoppingCart;

public class ShoppingCartDAO extends BaseDAO<ShoppingCart>{
    public ShoppingCartDAO() {
        super(ShoppingCart.class);
    }
}
