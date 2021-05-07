import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GetdataService {
private leaguelink  = '/api/getLeagueData';
private matchlink = '/api/getMatchData';
private generate = '/api/generateMatch';
  constructor(private httpclient:HttpClient) { }


public getleagueservice(){
  return this.httpclient.get(this.leaguelink);
}

public getmatchservice(){
  return this.httpclient.get(this.matchlink);
}

public getgenerateservice(){
  return this.httpclient.get(this.generate);
}

}