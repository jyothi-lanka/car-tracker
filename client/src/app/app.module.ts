import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";

import { AppComponent } from './app.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { RouterModule, Routes } from "@angular/router";
import {VehicleService} from "./vehicle-service/vehicle.service";
import {HttpClientModule} from '@angular/common/http';


const appRoutes: Routes = [
  {path: 'vehicles', component: VehicleListComponent},
  {path: '', redirectTo: '/vehicles', pathMatch: 'full'}
];
@NgModule({
  declarations: [
    AppComponent,
    VehicleListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [VehicleService],
  bootstrap: [AppComponent]
})
export class AppModule { }

