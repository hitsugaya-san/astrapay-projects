import { Component } from '@angular/core';
import { NotesComponent } from './notes/notes.component';

@Component({
  standalone: true,
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  imports: [NotesComponent]
})

export class AppComponent {
  title = 'astrapay-angular';
}
