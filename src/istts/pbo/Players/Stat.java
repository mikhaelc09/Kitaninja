package istts.pbo.Players;

public class Stat {
    private int health;
    private int mana;
    private int tools;
    private int attack;
    private int defense;
    private int speed;
    private int accuracy;
    private int criticalRate;

    public Stat(int health, int mana, int tools, int attack, int defense, int speed, int accuracy, int criticalRate) {
        this.health = health;
        this.mana = mana;
        this.tools = tools;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.accuracy = accuracy;
        this.criticalRate = criticalRate;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getTools() {
        return tools;
    }

    public void setTools(int tools) {
        this.tools = tools;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getCriticalRate() {
        return criticalRate;
    }

    public void setCriticalRate(int criticalRate) {
        this.criticalRate = criticalRate;
    }
}
