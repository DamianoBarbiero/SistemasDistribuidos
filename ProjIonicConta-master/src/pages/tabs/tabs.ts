import { Component } from '@angular/core';

import { CadastroPage } from '../cadastro/cadastro';
import { ContasPage } from '../contas/contas';

@Component({
  templateUrl: 'tabs.html'
})
export class TabsPage {

  tab1Root = CadastroPage;
  tab2Root = ContasPage;

  constructor() {

  }
}
