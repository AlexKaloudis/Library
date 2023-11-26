import { Component, Input, OnInit } from '@angular/core';
import { Library } from '../Models/library';
import { LibraryService } from '../Service/Library/library.service';
import { ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';
import { Book } from '../Models/book';

@Component({
  selector: 'app-library-detail',
  templateUrl: './library-detail.component.html',
  styleUrls: ['./library-detail.component.scss']
})
export class LibraryDetailComponent implements OnInit {
  library: Library = {
    id: '',
    name: '',
    books: [],
    members: []
  };
  // books : Book[] = [{
  //   id: '653f56044b98ec60a625558a',
  //   title: 'Politeia',
  //   pages: 245
  // },
  // {
  //   id: '653f5b374b98ec60a625558e',
  //   title: '15 rules for life',
  //   pages: 245
  // },
  // {
  //   id: '653f5b5c4b98ec60a625558f',
  //   title: 'Fahrenheit 165',
  //   pages: 245
  // }];

  constructor(
    private libraryService: LibraryService,
    private route: ActivatedRoute,
    private location: Location
    ) {}

  ngOnInit(): void {
    this.getLibrary();
  }

  getLibrary():void{
    const id = this.route.snapshot.paramMap.get('libraryId')!;
    this.libraryService.getLibrary(id)
    .subscribe(lib => {
      this.library = lib;
      lib.books = this.library.books;
      console.log('Library contains these books:', this.library.books);
    });
  }

  save(): void {
    if(this.library){
        this.libraryService.updateLibrary(this.library)
        .subscribe(() => this.goBack());
    }
  }
  goBack(): void {
    this.location.back();
  }

}
