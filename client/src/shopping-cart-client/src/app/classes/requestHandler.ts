import { Http } from "@angular/http";
import { FormGroup } from "@angular/forms";
import { Injectable } from "@angular/core";

export class RequestHandler {
    formGroup: FormGroup;
    endpoint: string;
    headers = new Headers();
    _http: Http;

    constructor(endpoint: string, http: Http) {
        this.endpoint = "http://localhost:8080/" + endpoint;
        this.headers.append('Content-Type', 'application/json');

        this._http = http;
    }

    POST(object?: Object) {
        return new Promise((resolve, reject) => {
            let obj = object != null ? object : this.formGroup.value;

            if (obj != null) {
                this._http.post(this.endpoint, obj, { headers: this.headers[0] })
                    .subscribe(data => {
                        this.formGroup.reset();
                        resolve(data);
                    }, err => {
                        reject("Error on insert");
                    });
            }
        });
    }

    GET() {
        return new Promise((resolve, reject) => {
            this._http.get(this.endpoint, { headers: this.headers[0] })
                .subscribe(data => {
                    let json = data.json();
                    resolve(json);
                }, err => {
                    reject("Not found entities");
                });
        });
    }

    DELETE(id: number) {
        return new Promise((resolve, reject) => {
            this._http.delete(this.endpoint+"/"+id, { headers: this.headers[0] })
                .subscribe(data => {
                    resolve(data);
                }, err => {
                    reject("Object not deleted");
                });
        });
    }
} 