import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws IOException {

        List<Car> taxis = new ArrayList<>();
        List<String> textfromfile = new ArrayList<>();
        Scanner in = new Scanner(new File("C:\\Users\\SponGer\\IdeaProjects\\Task1\\taxis.txt"));
        while (in.hasNextLine())
            textfromfile.add(in.nextLine());

        for (int i = 0; i < textfromfile.size(); i++) {
            String tempcar = textfromfile.get(i);
            String splited[] = tempcar.split(" ");
            taxis.add(new Car(splited[0],Integer.parseInt(splited[1]),Integer.parseInt(splited[2]), Double.parseDouble(splited[3]), splited[4]));
            taxis.get(i).fullCarInfo();
        }

        System.out.println();
        Collections.sort(taxis);
        for (int i = 0; i < taxis.size(); i++) taxis.get(i).fullCarInfo();

        int taxisprice = Car.taxisPrice(taxis);
        System.out.println();
        System.out.println("Общая стоимость машин в таксопарке: " + taxisprice);

        List<Car> fuelfiltered;
        fuelfiltered = Car.filterOnFuelUse(taxis,5,7);

        System.out.println();
        System.out.println("Список такси с расходом топлива от 5 до 7: ");
        for (int i = 0; i < fuelfiltered.size(); i++) fuelfiltered.get(i).fullCarInfo();

        int clientdistance = 12000;
        int passwantplaces = 4;
        double passwantprice = 1325;
        List<Car> carsforclient;

        carsforclient = Car.findCar(taxis, clientdistance,passwantplaces, passwantprice);
        System.out.println();
        System.out.println("Список подходящих такси: ");
        for (int i = 0; i < carsforclient.size(); i++)
        {
            System.out.println(carsforclient.get(i).getAutoModel() + "  Стоимость поездки: " + Math.round(carsforclient.get(i).pricePerdistance(clientdistance, carsforclient.get(i))) + "$");
        }
    }
}