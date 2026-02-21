package newLearning.LeetcodeWeekly.Feb_1;

import java.util.LinkedList;
import java.util.Queue;

public class Problems_487 {


  //Q3
  Queue<Integer> rider = new LinkedList<>(),driver = new LinkedList<>();

  public void addRider(int riderId) {
    rider.add(riderId);
  }

  public void addDriver(int driverId) {
    driver.add(driverId);
  }

  public int[] matchDriverWithRider() {
    if(!driver.isEmpty() && !rider.isEmpty())
      return new int[]{driver.remove(), rider.remove()};
    return new int[]{-1,-1};
  }

  public void cancelRider(int riderId) {
    if (!rider.isEmpty()) {
      rider.remove(riderId);
    }
  }
}
