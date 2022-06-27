import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TinyurlComponent } from './pages/tinyurl/page.tinyurl/page.tinyurl.component';
import { HomePageComponent } from './pages/home/homepage.component';
import { CalculatorComponent } from './pages/calculator/calculator.component';

const routes: Routes = [
  {path: "", component: HomePageComponent},
  {path: "tinyurl", component: TinyurlComponent},
  {path: "calculator", component: CalculatorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
