package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bases.BaseEntity;

@Entity
@Table(name="Item")
public class Item extends BaseEntity {
    @ManyToOne
    private ShoppingCart Cart;

    @OneToOne
    private Product Product;

    public ShoppingCart getCart() {
        return Cart;
    }

    public void setCart(ShoppingCart cart) {
        Cart = cart;
    }

    public Product getProduct() {
        return Product;
    }

    public void setProduct(Product product) {
        Product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Column
    private int Quantity;
}
