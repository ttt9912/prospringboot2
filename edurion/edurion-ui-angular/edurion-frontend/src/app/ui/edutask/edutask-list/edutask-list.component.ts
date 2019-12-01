import {Component, OnInit} from '@angular/core';
import {EdutaskDto} from '../../../data/edutask/edutask-dto';
import {EdutaskService} from '../../../data/edutask/edutask.service';

@Component({
  selector: 'app-edutask-list',
  templateUrl: './edutask-list.component.html',
  styleUrls: ['./edutask-list.component.scss']
})
export class EdutaskListComponent implements OnInit {
  edutasks: EdutaskDto[];

  constructor(private edutaskService: EdutaskService) {
  }

  ngOnInit() {
    this.getEdutasks();
  }

  getEdutasks(): void {
    this.edutaskService.getEdutasks()
      .subscribe(edutasks => this.edutasks = edutasks);
  }

}
