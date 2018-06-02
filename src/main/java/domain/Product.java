package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import bases.BaseEntity;

@Entity
@Table(name="product")
public class Product extends BaseEntity {
    @Column
    private String Name;

    @Column
    private double Value;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }
}
