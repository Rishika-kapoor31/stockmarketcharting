import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable, OperatorFunction } from 'rxjs';
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators';
import { Company } from 'src/app/models/Company';
import { CompanyService } from 'src/app/services/company.service';
import baseUrl from 'src/app/services/helper';
import { environment } from 'src/environments/environment';
import { MatSnackBar } from '@angular/material/snack-bar';
@Component({
  selector: 'app-manage-companies',
  templateUrl: './manage-companies.component.html',
  styleUrls: ['./manage-companies.component.css']
})
export class ManageCompaniesComponent implements OnInit {

  CompanyList:Company[];
  showCompanyForm=false;
  page=1;
  pageSize=4;
  update=false;
  searchCompany: string;
  companiesDatalist: Company[];
  companyToBeUpdated: Company;

  constructor(private snack :MatSnackBar,private http: HttpClient) { }

  ngOnInit(): void {
    
  }
  CompanyServiceApiUrl:any;

  getAllComapnies():void{
    this.http.get(`${baseUrl}/admin/companies`).subscribe(
      (response) => {
        console.log(response);
        this.CompanyList=<Company[]>response;
      },
      (error) => console.log(error)
    )
  }

  addCompany():void{
    this.update = false;
    this.showCompanyForm=!this.showCompanyForm;
  }

  updateCompany(company:Company):void{
    this.update =true;
    this.companyToBeUpdated = company;
    this.showCompanyForm=!this.showCompanyForm;
    
  }
  deleteCompany(company:Company):void{
    this.http.delete(`${baseUrl}/admin/companies/delete/`+company.id).subscribe(
      (response) => {
        console.log(response);
        this.snack.open("Deleted Successfully"," ",{
          duration:3000,
        });
        this.CompanyList=<Company[]>response;
      
      },
      (error) => console.log(error)
    ) 
  }

  addCompanySuccess(e:string){
    console.log(e);
    this.showCompanyForm=!this.showCompanyForm;
  }

  search(){
    if(this.searchCompany && this.searchCompany.length>2)
    this.getCompaniesMatching(this.searchCompany);
  }

  getCompaniesMatching(pattern:string):void{
    // if(this.CompanyList && this.CompanyList.length) return this.CompanyList;
    debounceTime(200),
    this.http.get(`${baseUrl}/admin/companies/`+pattern).subscribe(
      (response) => {
        console.log(response);
        this.CompanyList=<Company[]>response;
      },
      (error) => console.log(error)
    )
  
  }

}
