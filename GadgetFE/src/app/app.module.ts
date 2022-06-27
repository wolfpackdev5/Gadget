import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HomePageComponent } from './pages/home';
import { TinyurlComponent } from './pages/tinyurl/page.tinyurl/page.tinyurl.component';
import { CalculatorComponent } from './pages/calculator/calculator.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    TinyurlComponent,
    CalculatorComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    RouterModule,
    HttpClientModule,
    AppRoutingModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
