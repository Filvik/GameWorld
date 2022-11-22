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

    public void life() {

        creatingANewCharacter();
        crossroads();
    }

    private void creatingANewCharacter() {

        System.out.println("Введите:");
        System.out.println("1 - Создать персонажа автоматически");
        System.out.println("2 - Создать персонажа в ручную");

        while (!isCorrect) {
            Scanner scanner = new Scanner(System.in);
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

            Scanner scanner = new Scanner(System.in);
            String cross = scanner.nextLine();

            switch (cross) {
                case "1" -> {
                    drugDealer.purchase(personage);
                    boolean isCorrectTrade = false;
                    while (!isCorrectTrade) {

                        System.out.println("Куда вы хотите пойти?");
                        System.out.println("1 - Вернуться в город.");
                        System.out.println("2 - Продолжить торговлю.");

                        Scanner scannerTrade = new Scanner(System.in);
                        String trade = scannerTrade.nextLine();

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

                        Scanner scannerFight = new Scanner(System.in);
                        String tradeFight = scannerFight.nextLine();

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
        Scanner scannerName = new Scanner(System.in);
        String name = scannerName.nextLine();

        System.out.println("Введите количество жизни у нового персонажа");
        int health = 0;
        while (!isCorrect) {
            try {
                Scanner scannerHealth = new Scanner(System.in);
                health = scannerHealth.nextInt();
                isCorrect = check(health);
                if (!isCorrect)
                    System.out.println("Введите корректное значение! Уровень жизни не может быть отрицательным");
            } catch (InputMismatchException e) {
                System.out.println("Введено не корректное значение! Попробуйте еще раз.");
                isCorrect = false;
            }
        }

        System.out.println("Введите количества золота у нового персонажа");
        isCorrect = false;
        int gold = 0;
        while (!isCorrect) {
            try {
                Scanner scannerGold = new Scanner(System.in);
                gold = scannerGold.nextInt();
                isCorrect = check(gold);
                if (!isCorrect)
                    System.out.println("Введите корректное значение! Уровень золота не может быть отрицательным");
            } catch (InputMismatchException e) {
                System.out.println("Введено не корректное значение! Попробуйте еще раз.");
                isCorrect = false;
            }
        }

        System.out.println("Введите значение ловкости у нового персонажа");
        isCorrect = false;
        int dexterity = 0;
        while (!isCorrect) {
            try {
                Scanner scannerDexterity = new Scanner(System.in);
                dexterity = scannerDexterity.nextInt();
                isCorrect = check(dexterity);
                if (!isCorrect)
                    System.out.println("Введите корректное значение! Уровень ловкости не может быть отрицательным");
            } catch (InputMismatchException e) {
                System.out.println("Введено не корректное значение! Попробуйте еще раз.");
                isCorrect = false;
            }
        }

        System.out.println("Введите количество опыта у нового персонажа");
        isCorrect = false;
        int anExperience = 0;
        while (!isCorrect) {
            try {
                Scanner scannerAnExperience = new Scanner(System.in);
                anExperience = scannerAnExperience.nextInt();
                isCorrect = check(anExperience);
                if (!isCorrect)
                    System.out.println("Введите корректное значение! Уровень опыта не может быть отрицательным");
            } catch (InputMismatchException e) {
                System.out.println("Введено не корректное значение! Попробуйте еще раз.");
                isCorrect = false;
            }
        }

        System.out.println("Введите значение силы у нового персонажа");
        isCorrect = false;
        int force = 0;
        while (!isCorrect) {
            try {
                Scanner scannerForce = new Scanner(System.in);
                force = scannerForce.nextInt();
                isCorrect = check(force);
                if (!isCorrect)
                    System.out.println("Введите корректное значение! Уровень силы не может быть отрицательным");
            } catch (InputMismatchException e) {
                System.out.println("Введено не корректное значение! Попробуйте еще раз.");
                isCorrect = false;
            }
        }

        System.out.println("Введите уровень нового персонажа");
        isCorrect = false;
        int level = 0;
        while (!isCorrect) {
            try {
                Scanner scannerLevel = new Scanner(System.in);
                level = scannerLevel.nextInt();
                isCorrect = check(level);
                if (!isCorrect)
                    System.out.println("Введите корректное значение! Уровень не может быть отрицательным");
            } catch (InputMismatchException e) {
                System.out.println("Введено не корректное значение! Попробуйте еще раз.");
                isCorrect = false;
            }
        }

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
}
