import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class World {

    private Personage personage;
    private Monster monster;
    private final DrugDealer drugDealer = new DrugDealer();
    private boolean isCorrect = false;
    private boolean isCorrectCrossroads = false;
    private boolean isCorrectFight = false;
    private int element = 0;
    private final Scanner scanner = new Scanner(System.in);

    public void life() {

        creatingANewCharacter();
        crossroads();
    }

    private void creatingANewCharacter() {

        System.out.println("Введите:");
        System.out.println("1 - Создать персонажа автоматически");
        System.out.println("2 - Создать персонажа в ручную");

        while (!isCorrect) {
            String number = scanner.nextLine();

            if (number.equals("1")) {
                autoCreatingANewCharacter();

            } else if (number.equals("2")) {
                manualCreatingANewCharacter();

            } else {
                isCorrect = false;
                System.out.println("Введено не корректное значение! Попробуйте еще раз.");
            }
        }
    }

    private void personagePrint() {

        System.out.println("Получившегося персонажа:");
        System.out.println("Зовут " + personage.getName());
        System.out.println("Здоровье " + personage.getHealth());
        System.out.println("Золото " + personage.getGold());
        System.out.println("Ловкость " + personage.getDexterity());
        System.out.println("Опыт " + personage.getAnExperience());
        System.out.println("Сила " + personage.getForce());
        System.out.println("Уровень " + personage.getLevel());
    }

    private void crossroads() {

        while (!isCorrectCrossroads) {

            System.out.println("Куда вы хотите пойти?");
            System.out.println("1 - К торговцу");
            System.out.println("2 - В тёмный лес");
            System.out.println("3 - На выход");

            String cross = scanner.next();

            switch (cross) {
                case "1" -> {
                    drugDealer.purchase(personage);
                    boolean isCorrectTrade = false;
                    while (!isCorrectTrade) {

                        System.out.println("Куда вы хотите пойти?");
                        System.out.println("1 - Вернуться в город.");
                        System.out.println("2 - Продолжить торговлю.");

                        String trade = scanner.next();

                        switch (trade) {
                            case "1" -> isCorrectTrade = true;
                            case "2" -> drugDealer.purchase(personage);
                            default -> System.out.println("Введено не корректное значение! Попробуйте еще раз.");
                        }
                    }
                }
                case "2" -> {
                    battle();
                    while (!isCorrectFight) {

                        System.out.println("Куда вы хотите пойти?");
                        System.out.println("1 - Вернуться в город.");
                        System.out.println("2 - Сразиться с еще одним монстром.");

                        String tradeFight = scanner.next();

                        switch (tradeFight) {
                            case "1" -> isCorrectFight = true;
                            case "2" -> battle();
                            default -> System.out.println("Введено не корректное значение! Попробуйте еще раз.");
                        }
                    }
                }
                case "3" -> isCorrectCrossroads = true;
                default -> System.out.println("Введено не корректное значение! Попробуйте еще раз.");
            }
        }
    }

    private boolean check(int health) {

        return health >= 0;
    }

    private void creatingANewMonsters() {

        monster = new Monster(RandomService.getRandoms(100, 300), RandomService.getRandoms(30, 100), RandomService.getRandoms(30, 100));
    }

    private void autoCreatingANewCharacter() {

        String name = PesonageEnum.getPesonageEnum(new Random().nextInt(1, PesonageEnum.values().length + 1)).getType();
        personage = new Personage(name, RandomService.getRandoms(100, 300), RandomService.getRandoms(30, 100),
                RandomService.getRandoms(30, 100), 0, RandomService.getRandoms(30, 100), 0);
        personagePrint();
        isCorrect = true;
    }

    private void manualCreatingANewCharacter() {

        System.out.println("Введите имя нового персонажа");
        String name = scanner.nextLine();

         double health = creatingElements("количество жизни");
         int gold = creatingElements("количество золота");
         int dexterity = creatingElements("значение ловкости");
         int anExperience = creatingElements("количество опыта");
         double force = creatingElements("значение силы");
         int level = creatingElements("уровень");

        personage = new Personage(name, health, gold, dexterity, anExperience, force, level);
        personagePrint();
        isCorrect = true;
    }

    private void battle() {

        System.out.println("Бой начинается!)");
        creatingANewMonsters();
        Fight fight = new Fight(monster, personage);
        fight.run();
        isCorrectFight = false;
        if (personage.getHealth() <= 0) {
            System.out.println("Ваш персонаж погоб на поле боя. Вы можете начать новую игру.");
            isCorrectFight = true;
            isCorrectCrossroads = true;
        }
    }

    private int creatingElements(String elements){

        System.out.println("Введите " + elements + " нового персонажа");
        isCorrect = false;
        while (!isCorrect) {
            try {
                element = scanner.nextInt();
                isCorrect = check(element);
                if (!isCorrect)
                    System.out.println("Введите корректное значение! Уровень не может быть отрицательным");
            } catch (InputMismatchException e) {
                System.out.println("Введено не корректное значение! Попробуйте еще раз.");
                isCorrect = false;
                scanner.next();
            }
        }
        return element;
    }
}
