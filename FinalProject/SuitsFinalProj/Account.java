//Jenna Suits
//12/8/23
//Final project

public class Account
{
    //create variables
    private String user,pass,grade,name;
    //create object 
    public Account(String name,String user, String pass, String grade){
        this.user=user;
        this.pass=pass;
        this.grade=grade;
        this.name=name;
    }
    //format the display of the results
    @Override
    public String toString(){
        String s1=String.format("%-20s",name);
        String s2=String.format("%5s",user);
        String s3=String.format("%15s     ",pass);
        String s4=String.format("%5s",grade);
        return s1+s2+s3+s4;
    }
    //getters and setters
    public String getName(){
        return name;
    }
    public void setName(){
        this.name=name;
    }
    public String getUser(){
        return user;
    }
    public void setUser(){
        this.user=user;
    }
    public String getPass(){
        return pass;
    }
    public void setPass(){
        this.pass=pass;
    }
    public String getGrade(){
        return grade;
    }
    public void setGrade(String newGrade){
        this.grade=newGrade;
    }
    
}
