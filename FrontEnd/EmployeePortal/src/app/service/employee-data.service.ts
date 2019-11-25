import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../register/register.component';
import { Contants } from '../app.constant';

@Injectable({
  providedIn: 'root'
})
export class EmployeeDataService {

  constructor(private http: HttpClient,public consts: Contants) { }

  registerEmp(emp) {
    return this.http.post(this.consts.REGISTER_EMPLOYEE_API_URL, emp);
  }

  getAllEmployeesList() {
    return this.http.get<Employee[]>(this.consts.RETRIEVE_ALL_EMPLOYESS_API_URL);
  }
}
