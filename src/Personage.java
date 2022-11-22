
public class Personage extends Character {


    public Personage(String name, double health, int gold, int dexterity, int anExperience, double force,int level) {

        super(name,health,gold,dexterity,anExperience,force,level);

    }

    @Override
    public double attack() {
        System.out.println();
        if (hitProbability() == 10 && hitProbabilityDexterity() >= 60) {
            System.out.println("При атаке у " + super.getName() + " произошел супер удар");
            return super.getForce() * 2;
        } else if (hitProbability() >= 2) {

            if (hitProbabilityDexterity() >= 50) {
                System.out.println("Атака " + super.getName() + " получилась в полную силу");
                return super.getForce();
            } else if (hitProbabilityDexterity() >= 25) {
                System.out.println("Атака " + super.getName() + " получилась не в полную силу. Коэффициент силы 0.8");
                return super.getForce() * 0.8;
            } else {
                System.out.println("Атака " + super.getName() + " получилась не в полную силу. Коэффициент силы 0.5");
                return super.getForce() * 0.5;
            }
        } else {
            System.out.println("Атака " + super.getName() + " не получилась");
            return 0;
        }
    }


    static int hitProbability() {
        return RandomService.getRandoms(1, 10);
    }
    static int hitProbabilityDexterity() {
        return RandomService.getRandoms(10, 100);
    }

    @Override
    public void setAnExperience(int anExperience) {
        super.setAnExperience(anExperience);
        if (anExperience >= 1000) {
            super.setLevel(super.getLevel()+1);
            super.setDexterity(super.getDexterity() + 10);
            super.setForce(super.getForce() + 20);
            super.setAnExperience(super.getAnExperience()-1000);
            System.out.println("Персонаж " + super.getName() + " поднял уровень. Его текущий уровень = " + super.getLevel() +
                    " Текущая ловкость = " + super.getDexterity() + " Текущая сила = " + super.getForce());
        }
    }
}
