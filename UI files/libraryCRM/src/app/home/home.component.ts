import { Component, Input, OnInit, Type } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { LibraryService } from '../Service/Library/library.service';
import { MatIcon } from '@angular/material/icon';
import { Library } from '../Models/library';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  libraries: Library[] = [];
  constructor(private router: Router,
    private toastr: ToastrService, private libraryService : LibraryService) { }

  ngOnInit(): void {
    this.getLibraries();
  }
  getLibraries(): void {
    this.libraryService.getLibraries()
    .subscribe(libraries => this.libraries = libraries);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.libraryService.addLibrary({ name } as Library)
      .subscribe(lib => {
        this.libraries.push(lib);
      });
  }


  delete(library: Library):void {
    this.libraries = this.libraries.filter(l => l != library);
    this.libraryService.deleteLibrary(library.id).subscribe();
  }
}
