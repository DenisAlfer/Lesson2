import java.util.ArrayList;
import java.util.List;

public class Car implements Comparable<Car> {

    private String automodel;
    private int passangerplaces;
    private int carprice;
    private double fueluse;
    private String color;
    private static double fuelprice = 2.1;

    public Car(String automodel, int passangerplaces, int carprice, double fueluse, String color)
    {
        this.automodel = automodel;
        this.passangerplaces = passangerplaces;
        this.carprice = carprice;
        this.fueluse = fueluse;
        this.color = color;
    }

    public String getAutoModel() { return automodel;}

    public void  setAutomodel() { this.automodel = automodel;}

    public int getPassangerplaces()
    {
        return passangerplaces;
    }

    public void setPassangerplaces(int passangerplaces)
    {
        this.passangerplaces = passangerplaces;
    }

    public int getCarprice()
    {
        return carprice;
    }

    public void setCarprice(int carprice)
    {
        this.carprice = carprice;
    }

    public double getFueluse() {return fueluse;}

    public void setFueluse(double fueluse)
    {
        this.fueluse = fueluse;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public double getFuelprice() {return fuelprice;}

    public void setFuelprice() {this.fuelprice = fuelprice;}

    public void fullCarInfo()
    {
        System.out.println(automodel + " " + passangerplaces + " " + carprice + " " + fueluse + " " + color);
    }

    public static int taxisPrice(List<Car> taxis)
    {
        int summ = 0;

        for(int i = 0; i < taxis.size(); i++)
            summ += taxis.get(i).carprice;
        return summ;
    }

    //Фильтр по диапазону расходу топлива
    public static List<Car> filterOnFuelUse(List<Car> park, int value1, int value2)
    {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < park.size(); i++)
        {
            if ((park.get(i).getFueluse() >= value1) & (park.get(i).getFueluse() <= value2))
            {
                cars.add(park.get(i));
            }
        }
        return cars;
    }

    public double pricePerdistance(int distance, Car car) {

        double totalprice = (car.getFueluse() * car.getFuelprice() * distance)/100;
        return totalprice;
    }

    //Фильтр для клиентов
    public static List<Car> findCar(List<Car> park, int distance, int passplaces, double wantcost)
    {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < park.size(); i++)
        {
            if ((park.get(i).getPassangerplaces() >= passplaces) & ((park.get(i).pricePerdistance(distance, park.get(i)) <= wantcost)))
            {
                cars.add(park.get(i));
            }
        }
        return cars;
    }

    @Override
    public int compareTo(Car compprice) {
        int compareprice = compprice.getCarprice();
        return compareprice-this.carprice;
    }

}
