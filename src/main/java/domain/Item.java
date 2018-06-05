package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bases.BaseEntity;

@Entity
@Table(name="Item")
public class Item extends BaseEntity {
    @OneToOne
    private Product Product;

    @Column
    private int Quantity;

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
}
