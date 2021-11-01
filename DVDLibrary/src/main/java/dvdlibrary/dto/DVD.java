/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dto;

/**
 *
 * @author joaqu
 */
public class DVD {
    
    private String Title;
    private String ReleaseDate;
    private String MPAARating;
    private String DirectorName;
    private String Studio;
    private String UserRating;
    
    public DVD(String Title){
        this.Title = Title;
    }
    
    public String getTitle(){
        return Title;
    }
    
    public String getReleaseDate(){
        return ReleaseDate;
    }
    
    public void setReleaseDate(String RelaseDate){
        this.ReleaseDate = ReleaseDate;
    }
    
    public String getMPAARating(){
        return MPAARating;
    }
    
    public void setMPAARating(String MPAARating){
        this.MPAARating = MPAARating;
    }
    public String getDirectorName(){
        return DirectorName;
    }
    
    public void setDirectorName(String DirectorName){
        this.DirectorName = DirectorName;
    }
    public String getStudio(){
        return Studio;
    }
    
    public void setStudio(String Studio){
        this.Studio = Studio;
    }
    public String getUserRating(){
        return UserRating;
    }
    
    public void setUserRating(String UserRating){
        this.UserRating = UserRating;
    }
    
}
