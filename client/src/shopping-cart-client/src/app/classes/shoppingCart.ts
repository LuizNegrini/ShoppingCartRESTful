import { EntityBase } from "./entityBase";
import { Item } from "./item";
import { Product } from "./product";

export class ShoppingCart extends EntityBase {
    itens: Array<Item>;
    total: number;

    constructor(total: number, itens: Array<Item>) {
        super();

        this.itens = itens;
        this.total = total;
    }

    addItem(item: Item) {
        let p = this.findItem(item.product.id);
        if (p) {
            this.incrase(p, item.quantity);
        } else 
            this.itens.push(item);
        
        this.calculateAmount();
    }

    private incrase(item: Item, quantity: number){
        this.findItem(item.product.id).quantity += quantity;
    }

    private findItem(productId: number): Item {
        return this.itens.find(x => x.product.id === productId);
    }

    removeItem(id: number) {
        let p = this.findItem(id);
        let index = this.itens.indexOf(p);

        if (index !== -1)
            this.itens.splice(index, 1);

        this.calculateAmount();
    }

    private calculateAmount() {
        this.total = 0;
        this.itens.forEach((item) => {
            this.total += item.quantity * item.product.value;
        });
    }
}