abstract public class Character {

    private final String name;
    private double health;
    private int gold;
    private int dexterity;
    private int anExperience;
    private double force;
    private int level;

    public Character(String name, double health, int gold, int dexterity, int anExperience, double force, int level) {

        this.name = name;
        this.health = health;
        this.gold = gold;
        this.dexterity = dexterity;
        this.anExperience = anExperience;
        this.force = force;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    abstract double attack();

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getAnExperience() {
        return anExperience;
    }

    public void setAnExperience(int anExperience) {
        this.anExperience = anExperience;
    }

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }
}
