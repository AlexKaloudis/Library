import { Injectable } from '@angular/core';
import { Book } from '../../Models/book';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable,of } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { MessageService } from '../message.service';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  booksUrl = 'http://localhost:8080/api/v1/books';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http : HttpClient,private messageService : MessageService) { }

  private log(message: string) {
    this.messageService.add(`MessageService: ${message}`);
  }

  getBooks(): Observable<Book[]>{
    return this.http.get<Book[]>(this.booksUrl)
    .pipe(
      tap(_ => this.log('fetched libraries')),
      catchError(this.handleError<Book[]>('getLibraries', []))
    );
  }

  getBook(id: string): Observable<Book>{
    return this.http.get<Book>(this.booksUrl+'/' +id)
    .pipe(
      tap(_ => this.log(`fetched book id = ${id}`)),
      catchError(this.handleError<Book>(`getBook id = ${id}`))
    );
  }

  addBook(book: Book): Observable<Book>{
    return this.http.post<Book>(this.booksUrl,book,this.httpOptions)
    .pipe(
      tap((newBook:Book)=> this.log(`added book w/ id = ${newBook.id}`)),
      catchError(this.handleError<Book>('addBook'))
    );
  }

  updateBook(book: Book): Observable<Book>{
    return this.http.put<Book>(this.booksUrl,book,this.httpOptions)
    .pipe(
      tap(_=> this.log(`updated book w/ id = ${book.id}`)),
      catchError(this.handleError<any>('updateBook'))
    );
  }

  deleteBook(id: string): Observable<Book>{
    return this.http.delete<Book>(this.booksUrl+'/' +id)
    .pipe(
      tap(_ => this.log('deleted book w/ id = ${id}')),
      catchError(this.handleError<Book>('deleteBook'))
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
