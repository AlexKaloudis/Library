import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LibraryDetailComponent } from './library-detail/library-detail.component';
import { BookDashboardComponent } from './book-dashboard/book-dashboard.component';
import { BookDetailComponent } from './book-detail/book-detail.component';

const routes: Routes = [
  { path: '', redirectTo: 'Home', pathMatch: 'full'},
{ path: 'Home', component: HomeComponent },
{ path: 'LibraryDetail/:libraryId', component: LibraryDetailComponent },
{ path: 'Books', component: BookDashboardComponent },
{ path: 'BookDetail/:bookId', component: BookDetailComponent }
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
