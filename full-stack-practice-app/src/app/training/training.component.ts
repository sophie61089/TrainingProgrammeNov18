import { Component, OnInit } from '@angular/core';
import { Training } from '../training';
import { TrainingService } from '../training.service';
import { Participant } from '../participant';

@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.css']
})
export class TrainingComponent implements OnInit {

  trainings:Training[]
  trainingParticipants:Participant[]
  isEditable: boolean
  tid:number
  tname:String
  showSignUpForm:boolean
  tidForSignUp:number
  tnameForSignup:String

  constructor(private trainingService:TrainingService) { 
    this.trainings=[]
    this.trainingParticipants=[]
  }

  setTid(tid:number, tname:String){
    this.tid = tid
    this.tname = tname

    this.trainingService.getParticipants(tid).subscribe(
      res => {this.trainingParticipants = res}
    )
  }

  setTidForSignup(tidForSignUp:number, tnameForSignup:String){
    this.tidForSignUp = tidForSignUp
    this.tnameForSignup = tnameForSignup
  }

  toggleSignUpFormFields(){
    this.showSignUpForm = !this.showSignUpForm
  }

  toggleEditFields(){
    this.isEditable = !this.isEditable
  }

  addNewTraining(newTraining:Training){
    this.trainingService.addTraining(newTraining).subscribe(
      res =>{
        this.trainingService.getTrainings().subscribe(
          res => {this.trainings = res}
        )
      }
    )
  }

  deleteTraining(tid:number){
    this.trainingService.deleteTraining(tid).subscribe(
      res =>(
        this.trainingService.getTrainings().subscribe(
          res => {this.trainings = res}
        )
      )
    )
  }

  getParticipants(tid:number){
    this.trainingService.getParticipants(tid).subscribe(
      res => {this.trainingParticipants = res}
    )
  }

  addParticipantToTraining(tid:number, pid:number){
    this.trainingService.addParticipanttoTraining(tid, pid).subscribe(
      res =>(
        this.trainingService.getParticipants(tid).subscribe(
          res => {this.trainingParticipants = res}
        )
      )
    )
  }

  ngOnInit() {
    this.trainingService.getTrainings().subscribe(
      res => {this.trainings = res}
    )
  }

}
