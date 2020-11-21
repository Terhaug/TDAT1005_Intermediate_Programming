package Task1_Restaurant;

import java.util.ArrayList;
import java.util.Calendar;

public class Restaurant {
    private String name;
    private int establishingYear;
    private int numOfTables;
    private Table tables;

    public Restaurant(String name, int establishingYear, int numOfTables) {
        this.name = name;
        this.establishingYear = establishingYear;
        this.numOfTables = numOfTables;
        this.tables = new Table(numOfTables);
    }

    public String getName() {
        return name;
    }

    public int getEstablishingYear() {
        return establishingYear;
    }

    public int getNumOfTables() {
        return numOfTables;
    }
    public int getAgeOfRestaurant(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - establishingYear;
    }

    public int getNumOfAvailable() {
        return tables.getAmountAvailableTables();
    }

    public int getNumOfOccupied() {
        return tables.getNumOfOccupied();
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean makeTablesAvailable(int[] tableNumbers) {
        for(int i = 0; i < tableNumbers.length; i++) {
            if(tableNumbers[i] < 0 || tableNumbers[i] >= numOfTables) {
                return false;
            }
        }
        for(int i = 0; i < tableNumbers.length; i++) {
            tables.makeAvailable(tableNumbers[i]);
        }
        return true;
    }

    public boolean makeReservation(String name, int numOfTables) {
        return tables.makeReservation(name, numOfTables);
    }

    public String getReservations() {
        return tables.toString();
    }

    public int[] getTableNumber(String name) {
        return tables.getTableNumber(name);
    }

}
