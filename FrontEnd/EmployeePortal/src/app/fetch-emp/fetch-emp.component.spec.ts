import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchEmpComponent } from './fetch-emp.component';

describe('FetchEmpComponent', () => {
  let component: FetchEmpComponent;
  let fixture: ComponentFixture<FetchEmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FetchEmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FetchEmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
