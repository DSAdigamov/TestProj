import java.util.Arrays;

public class AirportData implements Comparable<AirportData> {

    private String[] columns;
    private static int argCol;

    public AirportData(String[] columns) {
        this.columns = columns;
    }

    public AirportData() {
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public static int getArgCol() {
        return argCol;
    }

    public static void setArgCol(int argCol) {
        AirportData.argCol = argCol;
    }

    @Override
    public int compareTo(AirportData o) {
        if (6 < AirportData.getArgCol() && AirportData.getArgCol()<11)
        {
            //return (int) (Double.parseDouble(this.getColumns()[AirportData.getArgCol()-1]) - Double.parseDouble(o.getColumns()[AirportData.getArgCol()-1]));
            if (Double.parseDouble(this.getColumns()[AirportData.getArgCol()-1]) > Double.parseDouble(o.getColumns()[AirportData.getArgCol()-1]))
            {
                return 1;
            }
            if (Double.parseDouble(this.getColumns()[AirportData.getArgCol()-1]) < Double.parseDouble(o.getColumns()[AirportData.getArgCol()-1]))
            {
                return -1;
            }
            if (this.getColumns()[AirportData.getArgCol()-1] == o.getColumns()[AirportData.getArgCol()-1])
            {
                return 0;
            }
            return 0;
        }
        else return this.getColumns()[AirportData.getArgCol()-1].compareTo(o.getColumns()[AirportData.getArgCol()-1]);
    }

    @Override
    public String toString() {
        return (this.getColumns()[1] + ", " + this.getColumns()[2] + ", " + this.getColumns()[3] + ", " + this.getColumns()[4] + ", " + this.getColumns()[5] + ", " +
                this.getColumns()[6] + ", " + this.getColumns()[1] + ", " + this.getColumns()[7] + ", "+ this.getColumns()[1] + ", " + this.getColumns()[8] + ", " +
                this.getColumns()[10] + ", " + this.getColumns()[11] + ", " + this.getColumns()[12] + ", " + this.getColumns()[13]);
    }
}
