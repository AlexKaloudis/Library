import { Injectable } from '@angular/core';
import { Library } from '../../Models/library';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable,of } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { MessageService } from '../message.service';
@Injectable({
  providedIn: 'root'
})
export class LibraryService {
  librariesUrl = 'http://localhost:8080/api/v1/libraries';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http : HttpClient,private messageService: MessageService) { }

  private log(message: string) {
    this.messageService.add(`LibraryService: ${message}`);
  }

  getLibraries(): Observable<Library[]> {
    return this.http.get<Library[]>(this.librariesUrl)
    .pipe(
        tap(_ => this.log('fetched libraries')),
        catchError(this.handleError<Library[]>('getLibraries', []))
      );
  }

  getLibrary(id: string): Observable<Library> {
    return this.http.get<Library>(this.librariesUrl +'/' +id)
    .pipe(
      tap(_ => this.log(`fetched library id = ${id}`)),
      catchError(this.handleError<Library>(`getLibrary id = ${id}`))
    );
  }

  addLibrary(library: Library): Observable<Library> {
    return this.http.post<Library>(this.librariesUrl, library, this.httpOptions).pipe(
      tap((newLibrary: Library) => this.log(`added Library w/ id=${newLibrary.id}`)),
      catchError(this.handleError<Library>('addLibrary'))
    );
  }

  updateLibrary(library: Library): Observable<any> {
    return this.http.put<Library>(this.librariesUrl, library, this.httpOptions).pipe(
      tap(_ => this.log(`updated Library w/ id=${library.id}`)),
      catchError(this.handleError<any>('updateLibrary'))
    );
  }

  deleteLibrary(id: string): Observable<Library> {

    return this.http.delete<Library>(this.librariesUrl+"/"+id,this.httpOptions).pipe(
      tap(_ => this.log(`deleted Library w/ id=${id}`)),
      catchError(this.handleError<Library>('deleteLibrary'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}


