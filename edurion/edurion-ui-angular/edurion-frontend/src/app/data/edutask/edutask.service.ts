import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {EdutaskDto} from './edutask-dto';
import {Observable} from 'rxjs/index';
import {tap} from 'rxjs/internal/operators';

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
