import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LibraryDashboardComponent } from './library-dashboard/library-dashboard.component';
import { AddLibraryComponent } from './add-library/add-library.component';
import { LibraryDetailComponent } from './library-detail/library-detail.component';

const routes: Routes = [
  { path: '', redirectTo: 'Home', pathMatch: 'full'},
{ path: 'Home', component: HomeComponent },
{ path: 'LibraryDashboard', component: LibraryDashboardComponent },
{ path: 'AddLibrary', component: AddLibraryComponent },
{ path: 'detail/:libraryId', component: LibraryDetailComponent } ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
