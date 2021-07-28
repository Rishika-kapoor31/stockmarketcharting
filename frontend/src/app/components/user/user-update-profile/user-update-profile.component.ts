import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { AuthenticationService } from 'src/app/services/auth.service';
import baseUrl from 'src/app/services/helper';
import { environment } from 'src/environments/environment';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-user-update-profile',
  templateUrl: './user-update-profile.component.html',
  styleUrls: ['./user-update-profile.component.css']
})
export class UserUpdateProfileComponent implements OnInit {

  currentUser:User;
  mobileNumber:any;
  newPassword:any;
  UserApiUrl:any;
  returnUrl: any;
  
  constructor(private authenticationService: AuthenticationService,
    private http: HttpClient, private router: Router, private route: ActivatedRoute,) {
    this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
  }
  ngOnInit(): void {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/login';
  }

  addMobileNumber(){
    this.http.post(`${baseUrl}/update/mobile`, this.mobileNumber).subscribe(
      (response) => {
        console.log(response);
      },
      (error) => console.log(error)
    )
  }

  updatePassword(){
    this.http.post(`${baseUrl}/update/password`, this.newPassword).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate([this.returnUrl]);
      },
      (error) => console.log(error)
    )
  }

}
