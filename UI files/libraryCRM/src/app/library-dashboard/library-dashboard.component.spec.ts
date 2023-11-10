import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibraryDashboardComponent } from './library-dashboard.component';

describe('LibraryDashboardComponent', () => {
  let component: LibraryDashboardComponent;
  let fixture: ComponentFixture<LibraryDashboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LibraryDashboardComponent]
    });
    fixture = TestBed.createComponent(LibraryDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
