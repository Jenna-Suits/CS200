
public class World
{
    //create variables
    private String country, continent;
    private Integer year;
    private Double happy, GDP, family, health, free, gene, trust, CPI;
    //create object 
    public World(String country, String continent, Integer year, Double happy,Double GDP,Double family,Double health,Double free,Double gene,Double trust,Double CPI){
        this.country=country;
        this.year=year;
        this.continent=continent;
        this.happy=happy;
        this.GDP=GDP;
        this.family=family;
        this.health=health;
        this.free=free;
        this.gene=gene;
        this.trust=trust;
        this.CPI=CPI;
    }
    //format the display of the results
    @Override
    public String toString(){
        String s1=String.format("%-20s",country);
        String s2=String.format("%5s",year);
        String s3=String.format("%10s       ",continent);
        String s4=String.format("%.2f       ",happy);
        String s5=String.format("%.2f       ",GDP);
        String s6=String.format("%.2f    ",family);
        String s7=String.format("%.2f        ",health);
        String s8=String.format("%.2f       ",free);
        String s9=String.format("%.2f       ",gene);
        String s10=String.format("%.2f      ",trust);
        String s11=String.format("%.2f      ",CPI);
        
        return s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11;
    }
    //getters and setters
    public String getCountry(){
        return country;
    }
    public void setCountry(){
        this.country=country;
    }
    
    public String getContinent(){
        return continent;
    }
    public void setContinent(){
        this.continent=continent;
    }
    
    public Integer getYear(){
        return year;
    }  
    public void setYear(){
        this.year=year;
    }
    
    public Double getHappy(){
        return happy;
    }
    public void setHappy(){
        this.happy=happy;
    }
    
    public Double getGDP(){
        return GDP;
    }
    public void setGDP(){
        this.GDP=GDP;
    }
    
    public Double getFamily(){
        return family;
    }
    public void setFamily(){
        this.family=family;
    }
    
    public Double getHealth(){
        return health;
    }
    public void setHealth(){
        this.health=health;
    }
    
    public Double getFree(){
        return free;
    }
    public void setFree(){
        this.free=free;
    }
    
    public Double getGene(){
        return gene;
    }
    public void setGene(){
        this.gene=gene;
    }
    
    public Double getTrust(){
        return trust;
    }
    public void setTrust(){
        this.trust=trust;
    }
    
    public Double getCPI(){
        return CPI;
    }
    public void setCPI(){
        this.CPI=CPI;
    }
}
