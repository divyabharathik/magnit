import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { QuestionService } from '../services/question-service';

@Component({
  selector: 'app-questionaire',
  templateUrl: './questionaire.component.html',
  styleUrls: ['./questionaire.component.scss']
})
export class QuestionaireComponent implements OnInit {
  feebackForm!: FormGroup;
  questionsList !: any[];
  satisfactionIndex = 0;
  currentQnIndex = 0;
  currentQuestion!: any;
  finish = false;
  finished = false;
  constructor(private _qService: QuestionService, private _formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.feebackForm = new FormGroup({
      radioGroup: new FormControl('', Validators.required),
      multiSelect: new FormControl('', Validators.required),
      textarea: new FormControl('', Validators.required)
    });


    this._qService.getQuestions().subscribe(data => {
      console.log(data);

      this.questionsList = data;
      this.currentQuestion = this.questionsList[0];
      console.log(data);
    });

  }
  previous() {
    console.log('cur index', this.currentQnIndex);
    if (this.currentQnIndex > 0) {
      this.currentQnIndex--;
      this.currentQuestion = this.questionsList[this.currentQnIndex];
    }
  }
  next() {
    let form = this.feebackForm.controls;
    if (this.currentQnIndex < this.questionsList.length - 1) {
      this.currentQnIndex++;
      this.currentQuestion = this.questionsList[this.currentQnIndex];
    } else {
      this.finish = true;
      this._qService.setQuestions(this.questionsList).subscribe(data => {
        this.satisfactionIndex = data;
        console.log("data",data);
      });
      setTimeout(() => {
        this.finished = true;
      }, 3000);

    }
  }

  setAnswer() {
    let form = this.feebackForm.controls;
    console.log('form', form);
    if (this.currentQuestion.questionType == 'radioGroup') {
      this.currentQuestion.answer = form['radioGroup'].value as Number;
    } else if (this.currentQuestion.questionType == 'multiSelect') {
      this.currentQuestion.answer = form['multiSelect'].value.reduce((a: any, b: any) => a + b, 0)
    } else {
      this.currentQuestion.answer = form['textarea'].value.length > 100 ? 5 : 1;
    }
  }


}
