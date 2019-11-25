import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { FetchEmpComponent } from './fetch-emp/fetch-emp.component';
import { Contants } from './app.constant';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    FetchEmpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [Contants],
  bootstrap: [AppComponent]
})
export class AppModule { }
