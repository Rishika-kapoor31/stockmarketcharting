import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { debounceTime } from 'rxjs/operators';
import { StockExchange } from 'src/app/models/StockExchange';
import baseUrl from 'src/app/services/helper';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-manage-exchanges',
  templateUrl: './manage-exchanges.component.html',
  styleUrls: ['./manage-exchanges.component.css']
})
export class ManageExchangesComponent implements OnInit {

  ExchangeList: StockExchange[];
  showExchangeForm=false;
  page=1;
  pageSize=4;
  searchExchange:string;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }
  StockExchangeServiceApiUrl:any;
  addExchange(){
    this.showExchangeForm=!this.showExchangeForm;
  }

  getAllexchanges(){
    this.http.get(`${baseUrl}/admin/stockexchanges`).subscribe(
      (response) => {
        console.log(response);
        this.ExchangeList=<StockExchange[]>response;
      },
      (error) => console.log(error)
    )
  }

  search(){
    if(this.searchExchange && this.searchExchange.length>2)
    this.getExchangesMatching(this.searchExchange);
  }

  getExchangesMatching(pattern:string):void{
    
    debounceTime(200),
    this.http.get(`${baseUrl}/admin/stockexchanges/`+pattern).subscribe(
      (response) => {
        console.log(response);
        this.ExchangeList=<StockExchange[]>response;
      },
      (error) => console.log(error)
    )
  
  }


}
