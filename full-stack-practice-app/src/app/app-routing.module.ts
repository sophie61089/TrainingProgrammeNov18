import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TrainingComponent } from './training/training.component';
import { ParticipantsComponent } from './participants/participants.component';


const routes: Routes = [
  {path: '', component: TrainingComponent},
  {path: 'participants', component: ParticipantsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
