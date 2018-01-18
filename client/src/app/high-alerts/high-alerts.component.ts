import { Component, OnInit } from '@angular/core';
import {AlertService} from "../alert-service/alert.service";

@Component({
  selector: 'app-high-alerts',
  templateUrl: './high-alerts.component.html',
  styleUrls: ['./high-alerts.component.css']
})
export class HighAlertsComponent implements OnInit {

  data;

  constructor(private alertService: AlertService) { }

  ngOnInit() {
    this.alertService.getHighAlerts()
      .subscribe(
        data=> this.data = data,
        error => console.log(error)
      );
  }

}
