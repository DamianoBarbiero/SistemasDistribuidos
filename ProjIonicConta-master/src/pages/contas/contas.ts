import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

import { RestapiServiceProvider } from '../../providers/restapi-service/restapi-service';


@Component({
  selector: 'page-contas',
  templateUrl: 'contas.html'
})
export class ContasPage {

  contas: any;

  constructor(public navCtrl: NavController, public restapiService : RestapiServiceProvider) {
    this.getContas();
  }

  public getContas() {
    this.restapiService.getContas()
    .then(data => {
      this.contas = data;
      console.log(this.contas);
    });
  }

}
