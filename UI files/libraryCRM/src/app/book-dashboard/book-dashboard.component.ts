import { Component, OnInit } from '@angular/core';
import { BookService } from '../Service/Book/book.service';
import { Book } from '../Models/book';

@Component({
  selector: 'app-book-dashboard',
  templateUrl: './book-dashboard.component.html',
  styleUrls: ['./book-dashboard.component.scss']
})
export class BookDashboardComponent implements OnInit {
  books: Book[] = [];
  pageSize: number = 0;
  constructor(private bookService: BookService) {
  }

  ngOnInit(): void {
    this.getBooks();
  }
  getBooks():void {
    this.bookService.getBooks()
    .subscribe(books => this.books = books);
  }
}
