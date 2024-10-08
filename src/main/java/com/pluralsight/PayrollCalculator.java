import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.pluralsight.Employee;

public class PayrollCalculator {
    public static void main(String[] args) {
        BufferedReader reader;

        try {

            reader = new BufferedReader(new FileReader("Mod01/employees.csv"));
            String line;


            reader.readLine();


            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split("\\|");


                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);


                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);


                employee.displayEmployeeInfo();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing the file: " + e.getMessage());
        }
    }
}

