import java.util.Random;

public class Monster extends Monsters {

    public Monster(double health, int dexterity, double force) {

        super(MonstersEnum.getMonstersEnum(new Random().nextInt(1, PesonageEnum.values().length + 1)),health,dexterity,force);
    }

    @Override
    public double attack() {

        if (hitProbability() == 1) {
            System.out.println("При атаке у " + super.getName() + " произошел супер удар");
            return super.getForce() * 2;
        }
        else if (hitProbability() >= 3) {

            if (super.getDexterity() >= 30) {
                System.out.println("Атака у " + super.getName() + " получилась");
                return super.getForce();
            } else {
                System.out.println("Атака у " + super.getName() + " получилась не в полную силу.");
                return super.getForce() * 0.8;
            }
        }
        else {
            System.out.println("Атака у " + super.getName() + " не получилась");
            return 0;
        }
    }

    static int hitProbability() {
        return RandomService.getRandoms(1, 10);
    }
}
