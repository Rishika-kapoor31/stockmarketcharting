import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Alert } from 'src/app/models/Alert';
import baseUrl from 'src/app/services/helper';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-add-stock-exchange',
  templateUrl: './add-stock-exchange.component.html',
  styleUrls: ['./add-stock-exchange.component.css']
})
export class AddStockExchangeComponent implements OnInit {

  addExchangeForm:FormGroup;

  constructor(private http: HttpClient,
    private fb:FormBuilder,
    private router: Router) { 
     
    }

  ngOnInit(): void {
    this.addExchangeForm = this.fb.group({
      stockExchangeName: ['',Validators.required],
      contactAddress: [''],
      remarks: [''],
      brief: ['']
    });
  }
  StockExchangeServiceApiUrl:any;
    onSubmit(){
      var seName =this.addExchangeForm.get('stockExchangeName');
      this.http.post(`${baseUrl}/admin/stockexchanges/add`, this.addExchangeForm.value).subscribe(
        (response) => {
          console.log(response);
        },
        (error) => {console.log(error);
       
      }

      )
    }
 

}
