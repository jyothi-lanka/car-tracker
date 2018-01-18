import { Component, OnInit } from '@angular/core';
import {AlertService} from "../alert-service/alert.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-alert-list',
  templateUrl: './alert-list.component.html',
  styleUrls: ['./alert-list.component.css']
})
export class AlertListComponent implements OnInit {

  alerts;
  vin;
  constructor(private route: ActivatedRoute, private alertService: AlertService) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.vin= params.vin;
      this.alertService.getAlertsByVin(params.vin)
        .subscribe(
          alerts => this.alerts = alerts,
          error => console.log(error));
    });
  }
}
