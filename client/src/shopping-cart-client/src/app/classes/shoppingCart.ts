export class ShoppingCart {
    constructor(
        private total: number,
        private itens: Array<Object>
    ) { }

    addItem(item: Object) {
        this.itens.push(item);
        this.calculateAmount();        
    }

    private calculateAmount() {
        this.total = 0;
        this.itens.forEach((item) => {
            this.total += item['quantity'] * item['product']['value'];
        });
    }
}