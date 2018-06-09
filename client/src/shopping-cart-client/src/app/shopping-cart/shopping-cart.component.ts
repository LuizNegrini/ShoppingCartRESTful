import { Component, OnInit } from '@angular/core';
import { RequestHandler } from '../classes/requestHandler';
import { Http } from '@angular/http';
import { FormGroup, FormControl, Validators, FormArray } from '@angular/forms';
import { ProductComponent } from '../product/product.component';
import { ShoppingCart } from '../classes/shoppingCart';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent extends RequestHandler implements OnInit {

  productsList = [];
  selectedItems = [];
  itemFormGroup: FormGroup;  
  shoppingCart: ShoppingCart;
  shoppingCarts: {};

  constructor(private http: Http) {
    super("shoppingcart", http);
  }

  ngOnInit() {
    this.formGroup = new FormGroup({
      total: new FormControl()
    });

    this.itemFormGroup = new FormGroup({
      quantity: new FormControl()
    });

    this.shoppingCart = new ShoppingCart(0, []);
    this.loadProducts();
  }

  loadProducts() {
    new ProductComponent(this._http)
      .GET()
      .then((data) => this.productsList = data as Array<Object>);

      this.getShoppingCarts();
  }

  addItem(product: Object) {
    if (this.itemFormGroup.value.quantity === null) {
      this.itemFormGroup.value.quantity = 1;
    }

    this.itemFormGroup.value.product = product;
    this.shoppingCart.addItem(this.itemFormGroup.value);

    this.selectedItems.push(this.itemFormGroup.value.product);
    this.itemFormGroup.reset();
    this.formGroup.reset();
  }

  create() {
    this.POST(this.shoppingCart)
      .then((data) => {
        this.getShoppingCarts();
        this.shoppingCart = new ShoppingCart(0, []);
      });
  }

  delete(id: number) {
    this.DELETE(id)
      .then((data) => {
        this.getShoppingCarts();
      });
  }

  getShoppingCarts() {
    this.GET()
      .then((data) => {
        this.shoppingCarts = data;
      });
  }
}
