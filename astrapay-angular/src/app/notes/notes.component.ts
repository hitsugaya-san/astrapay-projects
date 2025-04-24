import { Component, OnInit } from '@angular/core';
import { NotesService, Note } from './notes.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  standalone: true,
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.scss'],
  imports: [CommonModule, FormsModule]
})
export class NotesComponent implements OnInit {
  notes: Note[] = [];
  newNote: string = '';
  error: string = '';

  constructor(private notesService: NotesService) {}

  ngOnInit(): void {
    this.getNotes();
  }

  getNotes(): void {
    this.notesService.getNotes().subscribe((data) => {
      this.notes = data;
    });
  }

  addNote(): void {
   if (!this.newNote.trim()) {
     this.error = '';
   }

   this.notesService.addNote(this.newNote).subscribe({
     next: () => {
       this.newNote = '';
       this.error = '';
       this.getNotes();
     },
     error: (err) => {
       if (err.error?.error) {
         this.error = err.error.error;
       } else {
         this.error = 'Something went wrong.';
       }
     }
   });
  }

  deleteNote(noteId: string): void {
    this.notesService.deleteNote(noteId).subscribe(() => {
      this.getNotes();
    });
  }
}
