package auxillary;

import javafx.beans.property.*;

/**
 * Зеркальная копия объекта city прямиком с сервера
 */

public class City {
    private SimpleLongProperty id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty x;
    private SimpleIntegerProperty y;
    private SimpleStringProperty date;
    private SimpleIntegerProperty area;
    private SimpleLongProperty population;
    private SimpleLongProperty metersAboveSeaLevel;
    private SimpleLongProperty carCode;
    private SimpleStringProperty climate;
    private SimpleStringProperty standartOfLiving;
    private SimpleFloatProperty governor;
    private SimpleStringProperty username;

    public City(Long id, String name, Integer x, Integer y, String date, int area, Long population, Long metersAboveSeaLevel, Long carCode, String climate,String standartOfLiving, Float governor, String username){
        this.id = new SimpleLongProperty(id);
        this.name = new SimpleStringProperty(name);
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.date = new SimpleStringProperty(date);
        this.area = new SimpleIntegerProperty(area);
        this.population = new SimpleLongProperty(population);
        this.metersAboveSeaLevel = new SimpleLongProperty(metersAboveSeaLevel);
        this.carCode = new SimpleLongProperty(carCode);
        this.climate = new SimpleStringProperty(climate);
        this.standartOfLiving = new SimpleStringProperty(standartOfLiving);
        this.governor = new SimpleFloatProperty(governor);

        this.username = new SimpleStringProperty(username);
    }

    public Long getId(){ return id.get();}
    public void setId(Long value){ id.set(value);}

    public String getName(){ return name.get();}
    public void setName(String value){ name.set(value);}

    public Integer getX(){ return x.get();}
    public void setX(Integer value){ x.set(value);}

    public Integer getY(){ return y.get();}
    public void setY(Integer value){ y.set(value);}

    public String getDate(){ return date.get();}
    public void setDate(String value){ date.set(value);}

    public int getArea(){ return area.get();}
    public void setArea(int value){ area.set(value);}

    public Long getPopulation(){ return population.get();}
    public void setPopulation(Long value){ population.set(value);}

    public Long getMetersAboveSeaLevel(){ return metersAboveSeaLevel.get();}
    public void setMetersAboveSeaLevel(Long value){ metersAboveSeaLevel.set(value);}

    public Long getCarCode(){ return carCode.get();}
    public void setCarCode(Long value){ carCode.set(value);}

    public String getClimate(){ return climate.get();}
    public void setClimate(String value){ climate.set(value);}

    public String getStandartOfLiving(){ return standartOfLiving.get();}
    public void setStandartOfLiving(String value){ standartOfLiving.set(value);}

    public Float getGovernor(){ return governor.get();}
    public void setGovernor(Float value){ governor.set(value);}

    public String getUsername(){ return username.get();}
    public void setUsername(String value){ username.set(value);}


}

