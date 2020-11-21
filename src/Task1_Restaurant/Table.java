package Task1_Restaurant;

import java.util.ArrayList;

public class Table {
    private String[] tables;

    public Table(int amount) {
        tables = new String[amount];

    }

//    public int getAmount() {
//        return tables.length;
//    }

    public int getAmountAvailableTables() {
        int count = 0;
        for(String table : tables) {
            if(table == null) {
                count++;
            }
        }
        return count;
    }

    public int getNumOfOccupied() {
        return tables.length - getAmountAvailableTables();
    }

    public boolean makeAvailable(int tableNumber) {
        if(tableNumber < 0 || tableNumber >= tables.length) {
            return false;
        }

        tables[tableNumber] = null;
        return true;
    }

    public boolean makeReservation(String name, int numOfTables) {
        if(numOfTables > getAmountAvailableTables()) {
            return false;
        }
        while(numOfTables > 0) {
            for(int i = 0; i < tables.length; i++) {
                if(tables[i] == null) {
                    tables[i] = name;
                    break;
                }
            }
            numOfTables--;
        }
        return true;
    }

    public int[] getTableNumber(String name) {
        int[] reservedTables;
        int count = 0;

        for(String table : this.tables) {
            if(table != null) {
                if(table.equals(name)) {
                    count++;
                }
            }
        }

        if(count == 0) {
            reservedTables = new int[1];
            reservedTables[0] = -1;
            return reservedTables;
        }

        reservedTables = new int[count];
        int index = 0;
        for(int i = 0; i < this.tables.length; i++) {
            if(this.tables[i] != null) {
                if(this.tables[i].equals(name)) {
                    reservedTables[index] = i;
                    index++;
                }
            }
        }
        return reservedTables;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < tables.length; i++) {
            if(tables[i] == null) {
                result += "Table " + (i+1) + ":\n";
            } else {
                result += "Table " + (i+1) + ": " + tables[i] + "\n";
            }
        }
        return result;
    }
}

