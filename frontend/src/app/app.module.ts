import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component'
import { NavbarComponent } from './components/navbar/navbar.component';
import { ImportDataComponent } from './components/admin/import-data/import-data.component';
import { ManageCompaniesComponent } from './components/admin/manage-companies/manage-companies.component';
import { ManageExchangesComponent } from './components/admin/manage-exchanges/manage-exchanges.component';
import { UserIpoComponent } from './components/user/user-ipo/user-ipo.component';
import { UserUpdateProfileComponent } from './components/user/user-update-profile/user-update-profile.component';
import { ManageIPOsComponent } from './components/admin/manage-ipos/manage-ipos.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { UserLandingPageComponent } from './components/user/user-landing-page/user-landing-page.component';
import { AdminLandingPageComponent } from './components/admin/admin-landing-page/admin-landing-page.component';
import { JwtInterceptor } from './services/jwt.interceptor';
import { ErrorInterceptor } from './services/error.interceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddCompanyComponent } from './components/admin/add-company/add-company.component';
import { AddIpoComponent } from './components/admin/add-ipo/add-ipo.component';
import { AddStockExchangeComponent } from './components/admin/add-stock-exchange/add-stock-exchange.component';
import { ConfirmUserComponent } from './components/confirm-user/confirm-user.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import {MatListModule} from '@angular/material/list';
import {MatButtonModule} from '@angular/material/button';
import { ViewCompaniesComponent } from './components/user/view-companies/view-companies.component';
 import {MatSnackBarModule} from '@angular/material/snack-bar';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ImportDataComponent,
    ManageCompaniesComponent,
    ManageExchangesComponent,
    UserIpoComponent,
    UserUpdateProfileComponent,
    ManageIPOsComponent,
    LoginComponent,
    RegisterComponent,
    UserLandingPageComponent,
    AdminLandingPageComponent,
    LandingPageComponent,
    AddCompanyComponent,
    AddIpoComponent,
    AddStockExchangeComponent,
    ConfirmUserComponent,
    ViewCompaniesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatToolbarModule,
    MatIconModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    NgbModule,
    MatCardModule,
    MatListModule,
    MatButtonModule,
    MatSnackBarModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }