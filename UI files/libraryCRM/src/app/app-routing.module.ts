import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LibraryDetailComponent } from './library-detail/library-detail.component';

const routes: Routes = [
  { path: '', redirectTo: 'Home', pathMatch: 'full'},
{ path: 'Home', component: HomeComponent },
{ path: 'detail/:libraryId', component: LibraryDetailComponent } ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
