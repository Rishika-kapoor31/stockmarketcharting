import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { IPO } from 'src/app/models/IPO';
import baseUrl from 'src/app/services/helper';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-user-ipo',
  templateUrl: './user-ipo.component.html',
  styleUrls: ['./user-ipo.component.css']
})
export class UserIpoComponent implements OnInit {

  IPOList:IPO[];
  page=1;
  pageSize=10;
  
  constructor(private http: HttpClient ) { }

  ngOnInit(): void {
    this.getAllIPOs();
  }
  CompanyServiceApiUrl:any;
  getAllIPOs():void{
    this.http.get(`${baseUrl}/user/ipos`).subscribe(
      (response) => {
        console.log(response);
        this.IPOList=<IPO[]>response;
      },
      (error) => console.log(error)
    )
  }


}
