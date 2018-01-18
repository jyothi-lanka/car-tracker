import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import "rxjs/add/observable/throw";

@Injectable()
export class VehicleService {

  constructor(private http: HttpClient) { }

  getVehicles(): Observable<any[]> {
    return this.http.get('http://localhost:8000/api/vehicles')
      .map(response => response)
      .catch(error => Observable.throw(error.statusText));
  }
}




