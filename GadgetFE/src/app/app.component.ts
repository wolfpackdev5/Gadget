import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { TinyUrlService } from './tiny-url.service';
import { tinyUrl } from './tinyUrl';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public tinyurls!: tinyUrl[];
  public tinyUrl!: tinyUrl;

  constructor(private tinyUrlService: TinyUrlService) {
    
    }

  ngOnInit(): void {
      this.getTinys();
  }

  public getTinys(): void {
    this.tinyUrlService.getTiny().subscribe(
      (response: tinyUrl[]) => {
        this.tinyurls = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onCreateTiny(createForm: NgForm): void {
    this.tinyUrlService.addTiny(createForm.value).subscribe(
      (response: tinyUrl) => {
        console.log(response.tinyUrl);
        this.tinyUrl = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


}
