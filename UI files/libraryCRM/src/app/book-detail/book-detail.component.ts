import { Component, OnInit } from '@angular/core';
import { BookService } from '../Service/Book/book.service';
import { Book } from '../Models/book';
import { ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.scss']
})
export class BookDetailComponent implements OnInit {
  book: Book | undefined;
  constructor(private bookService: BookService,
    private route: ActivatedRoute,
    private location: Location) {

  }
  ngOnInit(): void {
      this.getBook();
  }
  getBook(): void {
    const id = this.route.snapshot.paramMap.get('bookId')!;
    this.bookService.getBook(id)
      .subscribe(book =>{this.book = book;
                        console.log(book)} );
  }

  save(): void {
    if(this.book){
        this.bookService.updateBook(this.book)
        .subscribe(() => this.goBack());
    }
  }
  goBack(): void {
    this.location.back();
  }
}
