import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const headers = new HttpHeaders({
  'Content-Type': 'application/json',
  'Access-Control-Allow-Origin': "*",
});

@Injectable()
export class QuestionService {
  BASE_URL = environment.BASE_URL + '/question';
  constructor(private http: HttpClient) {
  }

  public getQuestions(): Observable<any> {
    return this.http.get(this.BASE_URL, { headers: headers })
  }
  public setQuestions(questions: any[]): Observable<any> {
    return this.http.post(this.BASE_URL, questions, { headers: headers })
  }
}
