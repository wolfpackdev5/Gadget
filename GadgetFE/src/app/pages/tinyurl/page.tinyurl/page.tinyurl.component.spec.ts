import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Page.TinyurlComponent } from './page.tinyurl.component';

describe('Page.TinyurlComponent', () => {
  let component: Page.TinyurlComponent;
  let fixture: ComponentFixture<Page.TinyurlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Page.TinyurlComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Page.TinyurlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
