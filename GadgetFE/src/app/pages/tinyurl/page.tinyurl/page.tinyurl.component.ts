import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, Output, EventEmitter, SimpleChange, OnChanges, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { tinyUrl } from '../model/tinyUrl';
import { TinyUrlService } from '../service/tiny-url.service';



@Component({
  selector: 'app-page.tinyurl',
  templateUrl: './page.tinyurl.component.html',
  styleUrls: ['./page.tinyurl.component.css']
})
export class TinyurlComponent implements OnInit {
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

  public CreateTiny(createForm: NgForm): void {
    this.tinyUrlService.addTiny(createForm.value.originalUrl).subscribe(
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
