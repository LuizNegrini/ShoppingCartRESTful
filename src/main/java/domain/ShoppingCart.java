package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import bases.BaseEntity;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart extends BaseEntity{
    @OneToMany(cascade=CascadeType.ALL, mappedBy="Cart")
    private List<Item> Itens = new ArrayList<>();

    @Column
    private double total;

    public List<Item> getItens() {
        return Itens;
    }

    public void setItens(List<Item> itens) {
        Itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
