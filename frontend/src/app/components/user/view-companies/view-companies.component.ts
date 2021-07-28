import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from 'src/app/services/helper';
import { Company } from 'src/app/models/Company';
import { CompanyService } from 'src/app/services/company.service';
import { debounceTime } from 'rxjs/operators';

@Component({
  selector: 'app-view-companies',
  templateUrl: './view-companies.component.html',
  styleUrls: ['./view-companies.component.css']
})
export class ViewCompaniesComponent implements OnInit {

  CompanyList:Company[];
  showCompanyForm=false;
  page=1;
  pageSize=10;
  update=false;
  searchCompany: string;
  companiesDatalist: Company[];
  companyToBeUpdated: Company;

  addCompareFormType = 'company';
  showCompareForm = false;
  chartType='mscolumn2d';
  
  constructor(private http: HttpClient) {
   
      
  }

  ngOnInit(): void {
    // this.chartData.subscribe()
  }

  getAllComapnies():void{
    this.http.get(`${baseUrl}/user/companies`).subscribe(
      (response) => {
        console.log(response);
        this.CompanyList=<Company[]>response;
      },
      (error) => console.log(error)
    )
  } 
  search(){
    if(this.searchCompany && this.searchCompany.length>2)
    this.getCompaniesMatching(this.searchCompany);
  }

  getCompaniesMatching(pattern:string):void{
    // if(this.CompanyList && this.CompanyList.length) return this.CompanyList;
    debounceTime(200),
    this.http.get(`${baseUrl}/user/companies/`+pattern).subscribe(
      (response) => {
        console.log(response);
        this.CompanyList=<Company[]>response;
      },
      (error) => console.log(error)
    )
  
  }
}









  // changeCompareFormType(type:string){
  //   if(type == 'company') this.addCompareFormType = 'company';
  //   else if(type == 'sector') this.addCompareFormType = 'sector';
  //   this.showCompareForm=!this.showCompareForm;
  // }


  // addedComponent(e:any){
  //   this.changeCompareFormType('');

  //   // console.log(this.categories, this.dataset);
  //   this.caption = ((this.caption == "") ? "":this.caption +" Vs ")+ e.dataset.seriesname;
  //   this.setChart(e.categories, e.dataset);
    
  // }

  // setChart(categories:any, dataset:any){

  //   // if(!this.periodFix.fixed) this.categories[0].category = categories;
  //   // this.dataset.push(dataset);
  //   this.categories = categories;
  //   if(this.dataset[0].seriesname!="") this.dataset.push(dataset);
  //   else this.dataset[0]=dataset;
  //   console.log("response: ",this.categories, this.dataset);
  //   const dataSource = {
  //     chart: {
  //       "caption": this.caption,
  //       "subCaption": "Stock Price Analysis",
  //       "xAxisname": "DateTime",
  //       "yAxisName": "Stock Price (in INR)",
  //       "numberPrefix": "INR",
  //       "divlineColor": "#999999",
  //       "divLineIsDashed": "1",
  //       "divLineDashLen": "1",
  //       "divLineGapLen": "1",
  //       "toolTipColor": "#ffffff",
  //       "toolTipBorderThickness": "0",
  //       "toolTipBgColor": "#000000",
  //       "toolTipBgAlpha": "80",
  //       "toolTipBorderRadius": "2",
  //       "toolTipPadding": "5",
  //       "theme": "fusion"
  //     },
  //     // Chart Data - from step 2
  //     categories: this.categories,
  //     dataset: this.dataset
  //   };
  //   this.dataSource = dataSource;
  // }

  // setPeriod(e:any){
  //   this.periodFix = e;
  // }





