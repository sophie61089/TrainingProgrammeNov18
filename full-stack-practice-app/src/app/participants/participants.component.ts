import { Component, OnInit } from '@angular/core';
import { Participant } from '../participant';
import { ParticipantService } from '../participant.service';

@Component({
  selector: 'app-participants',
  templateUrl: './participants.component.html',
  styleUrls: ['./participants.component.css']
})
export class ParticipantsComponent implements OnInit {

  participants:Participant[]
  isEditable:boolean

  constructor(private participantService:ParticipantService) {
    this.participants=[]
   }

  addNewParticipant(newParticipant:Participant){
    this.participantService.addParticipant(newParticipant).subscribe(
      res =>{
        this.participantService.listParticipants().subscribe(
          res => {this.participants = res}
        )
      }
    )
  }

  toggleEditFields(){
    this.isEditable = !this.isEditable
  }

  deleteParticipant(pid:number){
    this.participantService.deleteParticipant(pid).subscribe(
      res =>(
        this.participantService.listParticipants().subscribe(
          res => {this.participants = res}
        )
      )
    )
  }

  ngOnInit() {
    this.participantService.listParticipants().subscribe(
      res => {this.participants = res
       
      }

    )
  }

}
