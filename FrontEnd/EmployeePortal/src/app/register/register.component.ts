import { Component, OnInit } from '@angular/core';
import { EmployeeDataService } from './../service/employee-data.service';
import { Router } from '@angular/router';

export class Employee {
  constructor(
    public id: number,
    public firstName: string,
    public lastName: string,
    public gender: String,
    public dob: Date,
    public department: string
  ) {

  }
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  emp: Employee;
  id: number
  message: string

  constructor(private empService: EmployeeDataService, private router: Router) { }

  ngOnInit() {

    this.emp = new Employee(0, '', '', '', null, '');
  }

  saveEmployee() {
    this.empService.registerEmp(this.emp)
      .subscribe(
        data => {
          console.log(data);
          this.message = "registration successful"
        }
      )
  }

}
