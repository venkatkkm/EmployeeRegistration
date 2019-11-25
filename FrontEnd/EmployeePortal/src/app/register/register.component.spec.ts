import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterComponent } from './register.component';
import { EmployeeDataService } from './../service/employee-data.service';
import { Router } from '@angular/router';

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;
  let empService : EmployeeDataService;
  let route : Router;
  let employee = {
    "firstName" : "Raj",
    "lastName" : "Kiran",
    "gender" : "male",
    "dob" : "2000-11-24",
    "department" : "IT"
  }

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('employee first name', () =>{
    const comp = new RegisterComponent(empService,route,);
    expect(employee.firstName).toEqual("Raj");
  })
  it('employee gender', () =>{
    const comp = new RegisterComponent(empService,route,);
    expect(employee.gender).toEqual("male");
    expect(employee.gender).toEqual("female");
  })
  it('employee gender in camel letters', () =>{
    const comp = new RegisterComponent(empService,route,);
    expect(employee.gender).toEqual("Male");
    expect(employee.gender).toEqual("Female");
  })
  it('employee department name', () =>{
    const comp = new RegisterComponent(empService,route,);
    expect(employee.department).toEqual("IT");
  })
});
