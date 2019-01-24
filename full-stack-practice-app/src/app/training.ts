import { Time } from "../../node_modules/@angular/common";
import { Participant } from "./participant";

export interface Training {
    trainingId:number
	trainingTitle:String
    trainingDescription:String
	trainingLeader:String
	trainingDate:Date
	trainingStartTime:Time
	trainingDuration:number
	trainingLocation:String
	trainingSpacesTotal:number
	trainingSpacesAvailable:number
	participants:Participant[]
}
