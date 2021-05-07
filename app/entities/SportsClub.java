package entities;

import java.io.Serializable;

public class SportsClub implements Serializable
{
    protected String clubName;
    protected String address;


    public SportsClub()
    {
    }

    public SportsClub(String clubName,  String address)
    {
        this.clubName = clubName;
        this.address = address;


    }
    //Getters
    public String getClubName() { return clubName; }
    public String getAddress()
    {
        return address;
    }


    //Setters
    public void setClubName(String clubName)
    {
        this.clubName = clubName;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }



}