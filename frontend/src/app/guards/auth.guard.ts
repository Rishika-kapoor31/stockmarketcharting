import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { AuthenticationService } from '../services/auth.service';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const currentUser = this.authenticationService.currentUserValue;
        if (currentUser) {
           
            if(!currentUser.confirmed) {
                this.router.navigate(['/confirm']);
                return false;
            }
            else
             if (route.data.roles && route.data.roles.indexOf(currentUser.userType) === -1) {
                
                this.router.navigate(['/']);
                return false;
            }

            
            return true;
        }

        
        this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
        return false;
    }
}