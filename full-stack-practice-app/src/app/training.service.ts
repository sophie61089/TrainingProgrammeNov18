import { Injectable } from '@angular/core';
import { Observable } from '../../node_modules/rxjs';
import { HttpClient, HttpHeaders } from '../../node_modules/@angular/common/http';
import { Training } from './training';
import { Participant } from './participant';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {

  rootURL: String
  constructor(private httpservice:HttpClient) {
    this.rootURL="http://localhost:9900/training"
  }

  getTrainings():Observable<Training[]>{
    return this.httpservice.get<Training[]>(this.rootURL+"/list")
  }

  addTraining(newTraining:Training):Observable<any>{
    const httpOpts = {
      headers: new HttpHeaders(
        {'Content-Type' : 'application/x-www-form-urlencoded;charset=UTF-8'}
      )
    }

    var reqBody = "title="+newTraining.trainingTitle+
    "&description="+newTraining.trainingDescription+
    "&leader="+newTraining.trainingLeader+
    "&date="+newTraining.trainingDate+
    "&start="+newTraining.trainingStartTime+
    "&duration="+newTraining.trainingDuration+
    "&location="+newTraining.trainingLocation+
    "&spacestot="+newTraining.trainingSpacesTotal+
    "&spacesavail="+newTraining.trainingSpacesAvailable

    console.log(reqBody)
    return this.httpservice.post<Training>(
      this.rootURL+"/register", reqBody, httpOpts
    )
  }

  deleteTraining(trainingId:number):Observable<Training>{
    return this.httpservice.request<Training>('DELETE', this.rootURL+"/delete",
  {
    headers: new HttpHeaders({'Content-Type': 'text/plain'}),
    body: trainingId
  })
  }

  getParticipants(trainingId:number):Observable<Participant[]>{
    return this.httpservice.get<Participant[]>(this.rootURL+"/participants?tid="+trainingId)
  }
  
  addParticipanttoTraining(trainingId:number, empId:number):Observable<any>{
    const httpOpts = {
      headers: new HttpHeaders(
        {'Content-Type' : 'application/x-www-form-urlencoded;charset=UTF-8'}
      )
    }

    var reqBody = "tid="+trainingId+"&pid="+empId

    return this.httpservice.post<Training>(
      this.rootURL+"/register-to-existing", reqBody, httpOpts
    )
  }
  
}
