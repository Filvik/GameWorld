abstract public class Monsters {

    private final MonstersEnum moniker;
    private double health;
    private final int dexterity;
    private final double force;

    public Monsters(MonstersEnum moniker, double health, int dexterity, double force) {

        this.moniker = moniker;
        this.health = health;
        this.dexterity = dexterity;
        this.force = force;
    }

    abstract double attack();

    public String getName() {
        return moniker.getType();
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getDexterity() {
        return dexterity;
    }

    public double getForce() {
        return force;
    }

}
