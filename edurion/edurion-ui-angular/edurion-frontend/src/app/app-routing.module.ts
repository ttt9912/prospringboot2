import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {EdutaskListComponent} from './ui/edutask/edutask-list/edutask-list.component';


const routes: Routes = [
  // {path: 'edutasks', component: EdutaskListComponent},
  // {path: '', redirectTo: '/edutasks', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
