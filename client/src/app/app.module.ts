import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";

import { AppComponent } from './app.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { RouterModule, Routes } from "@angular/router";
import {VehicleService} from "./vehicle-service/vehicle.service";
import {HttpClientModule} from '@angular/common/http';
import { AlertListComponent } from './alert-list/alert-list.component';
import {AlertService} from "./alert-service/alert.service";
import { HighAlertsComponent } from './high-alerts/high-alerts.component';

const appRoutes: Routes = [
  {path: 'vehicles', component: VehicleListComponent},
  {path: 'alerts/:vin', component: AlertListComponent},
  {path: 'high/alerts', component: HighAlertsComponent},
  {path: '', redirectTo: '/vehicles', pathMatch: 'full'}
];
@NgModule({
  declarations: [
    AppComponent,
    VehicleListComponent,
    AlertListComponent,
    HighAlertsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [VehicleService, AlertService],
  bootstrap: [AppComponent]
})
export class AppModule { }

