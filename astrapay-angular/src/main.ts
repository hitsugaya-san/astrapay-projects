import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { NotesComponent } from './app/notes/notes.component';

bootstrapApplication(NotesComponent, appConfig)
  .catch((err) => console.error(err));
