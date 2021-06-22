package istts.pbo.Enemy;

public class StatEnemy {
    private int enemyhealth;
    private int enemymana;
    private int enemyatt;
    private int enemydef;
    private int enemyspeed;
    private int enemyacc;
    private int enemycrit;
    private String enemysprite;

    public String getEnemysprite() {
        return enemysprite;
    }

    public void setEnemysprite(String enemysprite) {
        this.enemysprite = enemysprite;
    }

    public int getEnemyhealth() {
        return enemyhealth;
    }

    public void setEnemyhealth(int enemyhealth) {
        this.enemyhealth = enemyhealth;
    }

    public int getEnemymana() {
        return enemymana;
    }

    public void setEnemymana(int enemymana) {
        this.enemymana = enemymana;
    }

    public int getEnemyatt() {
        return enemyatt;
    }

    public void setEnemyatt(int enemyatt) {
        this.enemyatt = enemyatt;
    }

    public int getEnemydef() {
        return enemydef;
    }

    public void setEnemydef(int enemydef) {
        this.enemydef = enemydef;
    }

    public int getEnemyspeed() {
        return enemyspeed;
    }

    public void setEnemyspeed(int enemyspeed) {
        this.enemyspeed = enemyspeed;
    }

    public int getEnemyacc() {
        return enemyacc;
    }

    public void setEnemyacc(int enemyacc) {
        this.enemyacc = enemyacc;
    }

    public int getEnemycrit() {
        return enemycrit;
    }

    public void setEnemycrit(int enemycrit) {
        this.enemycrit = enemycrit;
    }

    public StatEnemy(int enemyhealth, int enemymana, int enemyatt, int enemydef, int enemyspeed, int enemyacc, int enemycrit,String enemysprite) {
        this.enemyhealth = enemyhealth;
        this.enemymana = enemymana;
        this.enemyatt = enemyatt;
        this.enemydef = enemydef;
        this.enemyspeed = enemyspeed;
        this.enemyacc = enemyacc;
        this.enemycrit = enemycrit;
        this.enemysprite=enemysprite;
    }
}
