import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tinyUrl } from '../model/tinyUrl';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class TinyUrlService {
  private apiServerUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  public getTiny(): Observable<tinyUrl[]> {
    return this.http.get<tinyUrl[]>(`${this.apiServerUrl}/all`);
}

  public addTiny(originalUrl: string): Observable<tinyUrl> {
    console.log(originalUrl);
      return this.http.post<tinyUrl>(`${this.apiServerUrl}/create`, originalUrl);
  }

}
