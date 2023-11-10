import { Component } from '@angular/core';
import {Library} from '../Models/library';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-add-library',
  templateUrl: './add-library.component.html',
  styleUrls: ['./add-library.component.scss']
})
export class AddLibraryComponent {
  library: Library = {
    id: '',
    name: ''
  };


  // addLibrary(library: Library): Observable<Library> {
  //   return this.http.post<Library>(this.heroesUrl, library, this.httpOptions).pipe(
  //     tap((newLibrary: Library) => this.log(`added library w/ id=${newLibrary.id}`)),
  //     catchError(this.handleError<Library>('addLibrary'))
  //   );
  // }
}


