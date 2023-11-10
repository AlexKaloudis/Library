import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AddLibraryComponent } from './add-library/add-library.component';
import { LibraryDashboardComponent } from './library-dashboard/library-dashboard.component';
import { ToastrModule } from 'ngx-toastr';
import { HttpClientModule } from '@angular/common/http';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule } from '@angular/forms';
import { LibraryDetailComponent } from './library-detail/library-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddLibraryComponent,
    LibraryDetailComponent,
    LibraryDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    MatIconModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
