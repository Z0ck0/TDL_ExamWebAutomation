package utils;
import org.testng.annotations.DataProvider;

public class DataProviderForWebTables {

        @DataProvider( name ="webTablesFormData" )

        public Object[][] webTablesFormData() {
            Object[][] data = new Object[3][6];

            // First set of data
            data[0][0] = "John";
            data[0][1] = "Doe";
            data[0][2] = "john.doe@example.com";
            data[0][3] = "25";
            data[0][4] = "18500";
            data[0][5] = "Accounting";

            // Second set of data
            data[1][0] = "Jane";
            data[1][1] = "Smith";
            data[1][2] = "jane.smith@example.com";
            data[1][3] = "30";
            data[1][4] = "33000";
            data[1][5] = "HR";

            // Third set of data
            data[2][0] = "Jack";
            data[2][1] = "Bridge";
            data[2][2] = "jack.bridge@example.com";
            data[2][3] = "22";
            data[2][4] = "46000";
            data[2][5] = "IT";

            return data;
        }
    }