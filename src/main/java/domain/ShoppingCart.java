package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import bases.BaseEntity;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart extends BaseEntity{
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
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
