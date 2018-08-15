import org.junit.Assert;
import org.junit.Test;

public class DistanceTest {

    @Test
    public void shouldReturnDistanceBetweenTwoPointsOnLine(){
        Integer[] pointA = new Integer[1];
        Integer[] pointB = new Integer[1];
        pointA[0] = 1;
        pointB[0] = 10;
        double distanceResult = ClassifierRunner.distance(pointA,pointB);
        Assert.assertEquals(9,distanceResult,0);
    }

}
