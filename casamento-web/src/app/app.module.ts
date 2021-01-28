import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './views/home/home.component';
import { ListaPresenteComponent } from './views/lista-presente/lista-presente.component';
import { CerimoniaComponent } from './views/cerimonia/cerimonia.component';
import { MensagensComponent } from './views/mensagens/mensagens.component';
import { NossaHistoriaComponent } from './views/nossa-historia/nossa-historia.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListaPresenteComponent,
    CerimoniaComponent,
    MensagensComponent,
    NossaHistoriaComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
 

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
