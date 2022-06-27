import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  //send to the back for calculation and logging
  calculate(display: any): Observable<any>{
    return this.http.post(`${this.apiUrl}/calculate/${display}`, display);
  }

  
}
