import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GradeEntryComponent } from './grade-entry/grade-entry.component';
import { GradeEntryListComponent } from './grade-entry-list/grade-entry-list.component';
import { GradeEntryService } from './services/grade-entry.service';

@NgModule({
  declarations: [
    AppComponent,
    GradeEntryComponent,
    GradeEntryListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [GradeEntryService],
  bootstrap: [AppComponent]
})
export class AppModule { }