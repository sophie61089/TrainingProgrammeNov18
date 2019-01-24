import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../node_modules/@angular/common/http';
import { Observable } from '../../node_modules/rxjs';
import { Participant } from './participant';

@Injectable({
  providedIn: 'root'
})
export class ParticipantService {

  rootURL: String
  constructor(private httpsvc:HttpClient) {
    this.rootURL="http://localhost:9900/participants"
   }

   listParticipants():Observable<Participant[]>{
    return this.httpsvc.get<Participant[]>(this.rootURL+"/list")
   }

   addParticipant(newParticipant:Participant):Observable<any>{
    const httpOpts = {
      headers: new HttpHeaders(
        {'Content-Type' : 'application/x-www-form-urlencoded;charset=UTF-8'})
    }

    var reqBody = "name="+newParticipant.employeeName

    return this.httpsvc.post<Participant>(
      this.rootURL+"/register", reqBody, httpOpts)
   }

   deleteParticipant(participantId:number):Observable<Participant>{
    return this.httpsvc.request<Participant>('DELETE', this.rootURL+"/delete", 
      {
        headers: new HttpHeaders({'Content-Type': 'text/plain'}),
        body: participantId
      })
  }
}
