import { Component, OnInit } from '@angular/core';
import { Employee } from '../register/register.component';
import { EmployeeDataService } from './../service/employee-data.service';

@Component({
  selector: 'app-fetch-emp',
  templateUrl: './fetch-emp.component.html',
  styleUrls: ['./fetch-emp.component.css']
})
export class FetchEmpComponent implements OnInit {

  emps: Employee[]
  constructor(private empService: EmployeeDataService) { }

  ngOnInit() {
    this.allEmployees();
  }

  allEmployees() {
    this.empService.getAllEmployeesList().subscribe(
      response => {
        console.log(response);
        this.emps = response;
      }
    )
  }
}
