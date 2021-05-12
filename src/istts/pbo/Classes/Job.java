package istts.pbo.Classes;

public class Job {
    int health;
    int attack;
    int def;
    int mana;
    int speed;
    int acc;
    int critrate;
    String classname;

    public Job(int health, int attack, int def, int mana, int speed, int acc, int critrate, String classname) {
        this.health = health;
        this.attack = attack;
        this.def = def;
        this.mana = mana;
        this.speed = speed;
        this.acc = acc;
        this.critrate = critrate;
        this.classname = classname;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public int getCritrate() {
        return critrate;
    }

    public void setCritrate(int critrate) {
        this.critrate = critrate;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
