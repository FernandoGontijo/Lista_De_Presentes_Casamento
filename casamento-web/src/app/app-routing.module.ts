import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { ListaPresenteComponent } from './views/lista-presente/lista-presente.component';
import { NossaHistoriaComponent } from './views/nossa-historia/nossa-historia.component';
import { CerimoniaComponent } from './views/cerimonia/cerimonia.component';
import { MensagensComponent } from './views/mensagens/mensagens.component';


const routes: Routes = [
  {
    path: '', redirectTo: '/home', pathMatch:'full'
  },
  {
    path: 'home', component: HomeComponent
  },
  {
    path: 'historia', component: NossaHistoriaComponent
  },
  {
    path: 'presentes', component: ListaPresenteComponent
  },
  {
    path: 'cerimonia', component: CerimoniaComponent
  },
  {
    path: 'mensagens', component: MensagensComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
