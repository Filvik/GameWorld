import java.util.Random;

public class RandomService {

    public static int getRandoms(int val1, int val2) {
        Random randoms = new Random();
        return randoms.nextInt(val1, val2);
    }
}
