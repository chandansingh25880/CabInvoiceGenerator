import InvoiceSummary.InvoiceSummary;
import RideRepository.RideRepository;
import com.invoicegenerator.InvoiceGenerator;
import com.invoicegenerator.Ride;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.2;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);

    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(30, fare, 0.0);

    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);

    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary1() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        RideRepository riderepo = new RideRepository();
        riderepo.addRidetoUser("User", new Ride(2.0, 5));
        riderepo.addRidetoUser("User", new Ride(0.1, 1));
        InvoiceSummary summary = invoiceGenerator.calculateFare(riderepo.getRides("User"));
        InvoiceSummary exceptedinvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(exceptedinvoiceSummary, summary);

    }
}
