public class Fight implements Runnable {

    Monster monster;
    Personage personage;
    private boolean turn = true;

    public Fight(Monster monster, Personage personage) {

        this.monster = monster;
        this.personage = personage;
    }

    public void run() {

        while ((monster.getHealth() > 0) && (personage.getHealth() > 0)) {

            double damage;

            if (turn) {
                damage = personage.attack();
                monster.setHealth(monster.getHealth() - damage);
                turn = false;
                System.out.printf("Персонаж " + personage.getName() + " атаковал " + monster.getName() + " и нанес урон %1$,.2f%n\n", damage);
            } else {
                damage = monster.attack();
                personage.setHealth(personage.getHealth() - damage);
                turn = true;
                System.out.printf("Монстр " + monster.getName() + " атаковал " + personage.getName() + " и нанес урон %1$,.2f\n", damage);
            }
        }

        if (!turn) {
            System.out.println("Победил " + personage.getName());
            personage.setAnExperience(personage.getAnExperience() + 500);
            personage.setGold(personage.getGold() + 200);
            System.out.println("У персонажа осталось " + personage.getHealth() + " здоровья. Не забудьте его пополнить перед следующим сражением");
            System.out.println("У персонажа " + personage.getGold() + " золота и " + personage.getAnExperience() + " опыта.");
        }
        else {
            System.out.println("Победил " + monster.getName() + ". Вы проиграли!");
        }
    }
}

