import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { MatSort } from '@angular/material';
import {MatTableDataSource} from '@angular/material/table';
import {GetdataService} from '../getdata.service';



export interface MatchData {
  teamOne: string;
  teamTwo: string;
  location: string;
  date: string;
  teamOneGoals: number;
  teamTwoGoals: number;
}



@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})


export class MatchComponent implements OnInit,AfterViewInit {

   MATCH_DATA: MatchData[];
  dataSource;
  

  displayedColumns: string[] = [ 'teamOne', 'teamTwo', 'location','date','teamOneGoals','teamTwoGoals'];
  
  @ViewChild(MatSort) sort: MatSort;
  enterdate: string;
  constructor(private match: GetdataService) { 
    
  };
  
  
  public generate() {
    let genresponse = this.match.getgenerateservice()
    genresponse.subscribe(report=>this.dataSource.data=report as MatchData[])
    this.ngAfterViewInit();
    
  }

  ngOnInit(){
    }
  
  ngAfterViewInit() {
    this.match.getmatchservice().subscribe(data =>{
      this.MATCH_DATA = data as MatchData[];
      this.dataSource = new MatTableDataSource(this.MATCH_DATA);
      this.dataSource.sort = this.sort;
      
     
      
    })
   }
   search(){
    if(this.enterdate == ""){
      this.ngAfterViewInit();
    }else{
      this.dataSource.data = this.dataSource.data.filter(res =>{
        let date: string = res.date.day  + "/" + res.date.month + "/" + res.date.year;
        return date.match(this.enterdate);
      });
    }
  
   
  
  }
  
  

}