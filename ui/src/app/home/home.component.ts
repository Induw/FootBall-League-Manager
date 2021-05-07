import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { MatSort } from '@angular/material';
import {MatTableDataSource} from '@angular/material/table';
import {GetdataService} from '../getdata.service';



export interface LeagueData {
  clubName: string;
  matchesPlayed: number;
  wins: number;
  draws: number;
  losses: number;
  goalsScored: number;
  goalsConceded: number;
  goalDifference:number;
  points: number;
}



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})


export class HomeComponent implements OnInit,AfterViewInit {

   LEAGUE_DATA: LeagueData[];
  dataSource;

  displayedColumns: string[] = [ 'clubName', 'matchesPlayed', 'wins','draws','losses','goalsScored','goalsConceded','goalDifference','points'];
  
  @ViewChild(MatSort) sort: MatSort;
  constructor(private league: GetdataService) { }
  
  ngOnInit(){
    }
  ngAfterViewInit() {
    this.league.getleagueservice().subscribe(data =>{
      this.LEAGUE_DATA = data as LeagueData[];
      console.log(data);
      this.dataSource = new MatTableDataSource(this.LEAGUE_DATA);
      this.dataSource.sort = this.sort;
    })
    

  }

}