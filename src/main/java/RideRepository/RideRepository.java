package RideRepository;

import com.invoicegenerator.Ride;

import java.util.HashMap;

public class RideRepository {
    private String user;
    private Ride ride;
    private Object Userid;

    public void addRidetoUser(String user, Ride ride) {
        this.user = user;
        this.ride = ride;
    }

    public Ride[] getRides(String user) {
        HashMap<Object, Object> rideRepositoryMap = null;
        if (rideRepositoryMap.containsKey(Userid)) {

            final Object o = rideRepositoryMap.get(Userid);
            return (Ride[]) o;
        } else {
            return null;
        }

    }
}
