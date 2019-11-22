import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {EdutaskDto} from './edutask-dto';
import {Observable, of} from "rxjs/index";
import {catchError, tap} from "rxjs/internal/operators";

// TODO: move entire directory to data
@Injectable({
  providedIn: 'root'
})
export class EdutaskService {
  private url = 'api/edutasks';

  constructor(private http: HttpClient) {
  }

  getEdutasks(): Observable<EdutaskDto[]> {
      return this.http.get<EdutaskDto[]>(this.url)
        .pipe(
          tap(_ => console.log('fetched all edutasks from http')),
        );
  }
}
