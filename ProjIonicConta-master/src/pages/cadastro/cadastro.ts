import { Component } from '@angular/core';
import { NavController,  NavParams, ViewController } from 'ionic-angular';

import { RestapiServiceProvider } from '../../providers/restapi-service/restapi-service';

import { ToastController } from 'ionic-angular';
import { ContasPage } from '../contas/contas';

@Component({
  selector: 'page-cadastro',
  templateUrl: 'cadastro.html'
})
export class CadastroPage {

  cadastro : any;

  constructor(public navCtrl: NavController, 
              public navParams: NavParams, 
              public view: ViewController, 
              public restapiService : RestapiServiceProvider, 
              private toastCtrl: ToastController) {

    this.cadastro = navParams.get('cadastro') || {};
  }

  saveConta()  {
    this.restapiService.saveConta(this.cadastro)
    .then(data => {
      this.presentToast();
      this.clearFields();
    });
  }

  presentToast() {
    let toast = this.toastCtrl.create({
      message: 'Registro inserido com sucesso!',
      duration: 3000,
      position: 'top'
    });
  
    toast.onDidDismiss(() => {
      console.log('Dismissed toast');
    });
  
    toast.present();
  }

  clearFields(){
    this.cadastro.descricao = "";
    this.cadastro.numConta = "";
    this.cadastro.valor = "";
  }

}
