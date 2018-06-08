import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpModule, Http, RequestOptions, RequestMethod } from '@angular/http';
import { RequestHandler } from '../classes/requestHandler'


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent extends RequestHandler implements OnInit {
  //productForm: FormGroup;
  products: {};

  constructor(private http: Http) {
    super("product", http);
  }

  ngOnInit() {
    this.formGroup = new FormGroup({
      name: new FormControl(null, Validators.required),
      value: new FormControl(null, Validators.required),
    });

    this.getProducts();
  }

  create() {
    this.POST()
      .then((data) => {
        this.getProducts();
      });
  }

  getProducts() {
    this.GET()
      .then((data) => {
        this.products = data;
      });
  }
}
