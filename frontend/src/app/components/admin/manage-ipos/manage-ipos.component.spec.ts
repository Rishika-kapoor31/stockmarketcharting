import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageIposComponent } from './manage-ipos.component';

describe('ManageIposComponent', () => {
  let component: ManageIposComponent;
  let fixture: ComponentFixture<ManageIposComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageIposComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageIposComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
