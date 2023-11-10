import { Component, OnInit } from '@angular/core';
import { Library } from '../Models/library';
import { LibraryService } from '../Service/library.service';
import { ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-library-detail',
  templateUrl: './library-detail.component.html',
  styleUrls: ['./library-detail.component.scss']
})
export class LibraryDetailComponent implements OnInit {
  library : Library | undefined;

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
    .subscribe(lib => this.library = lib);
    // console.log(id);
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
