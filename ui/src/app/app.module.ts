import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSortModule} from '@angular/material/sort';
import {MatButtonModule} from '@angular/material/button';
import { MatFormFieldModule, MatInputModule } from '@angular/material';
import { FormsModule } from '@angular/forms';




import { AppComponent } from './app.component';
import { AppService } from './app.service';
import { AppHttpInterceptorService } from './http-interceptor.service';
import { HomeComponent } from './home/home.component';
import { MatchComponent} from './match/match.component';



const routes: Routes = [
  {
    path:'',component: HomeComponent
  },
  {
    path:'match',component: MatchComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MatchComponent
  ],
  imports: [
    BrowserModule,
    MatTableModule,
    HttpClientModule,
    MatSortModule,
    MatButtonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    BrowserAnimationsModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'Csrf-Token',
      headerName: 'Csrf-Token',
    }),
    RouterModule.forRoot(routes)
  
  ],
  providers: [
    AppService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
