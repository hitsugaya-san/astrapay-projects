
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Note {
  id: string;
  content: string;
  createdAt: string;
}

@Injectable({ providedIn: 'root' })
export class NotesService {
private apiUrl = 'http://localhost:8080/api/notes';

constructor(private http: HttpClient) {}

  getNotes(): Observable<Note[]> {
    return this.http.get<Note[]>(this.apiUrl);
  }

  addNote(content: string): Observable<Note> {
    return this.http.post<Note>(this.apiUrl, { content });
  }

  deleteNote(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
