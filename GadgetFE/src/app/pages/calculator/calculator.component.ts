import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CalculatorService } from './service/calculator.service';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  result!: number;

  constructor(private calcService: CalculatorService) { }

  ngOnInit(): void {
  }

  //clear the display
  clear() {
    (document.getElementById("display") as HTMLInputElement).value = "";
  }

  //write to display
  display(value: any) {
    console.log(value);
    (document.getElementById("display") as HTMLInputElement).value += value;
  }

  sendToBack() {
    var numb = (document.getElementById("display") as HTMLInputElement).value;
    this.calcService.calculate(numb).subscribe(
      (response: number) => {
        console.log(response);
        this.result = response;

      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      });
  }
}
