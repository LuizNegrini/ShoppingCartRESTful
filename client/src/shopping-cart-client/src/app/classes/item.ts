import { EntityBase } from "./entityBase";
import { Product } from "./product";

export class Item extends EntityBase {
    product: Product;
    quantity: number;
}