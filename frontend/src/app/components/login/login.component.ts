import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthenticationService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = this.fb.group({
    username: ['', Validators.required], 
    password: ['', Validators.required] 
  });
  returnUrl: string;
  error:string;
  submitted:boolean;

  constructor(
    private snack :MatSnackBar,
    private fb:FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService
  ) {
    if (this.authenticationService.currentUserValue){
      this.router.navigate(['/']);
    }
    this.submitted=false;
   }

  ngOnInit(): void {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  onSubmit(){

    this.authenticationService.login(this.loginForm.controls.username.value, this.loginForm.controls.password.value)

    .pipe(first())
    .subscribe(
        data => {
            this.router.navigate([this.returnUrl]);
        },
        error => {
            this.error = error;
            this.snack.open("Invalid Credentials!"," ",{
              duration:3000,
            });
        });
  }
}
