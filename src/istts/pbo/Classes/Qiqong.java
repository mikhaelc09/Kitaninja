package istts.pbo.Classes;

public class Qiqong extends Class{
    public Qiqong(int health, int attack, int def, int mana, int speed, int lvl, int acc, int critrate, String classname) {
        super(health, attack, def, mana, speed, lvl, acc, critrate, classname);
    }
    public Qiqong() {
        super(70,25,15,150,10,1,0,0,"qiqong");
    }
}
class Fire extends Qiqong{
    public Fire(Class ba){
        this.health=70;
        this.attack=45;
        this.def=15;
        this.mana=250;
        this.speed=10;
        this.classname="Fire";

    }
}

class Water extends Qiqong{
    public Water(Class bb){
        this.health=80;
        this.attack=30;
        this.def=20;
        this.mana=200;
        this.speed=10;
        this.classname="Water";

    }
}

class Wind extends Qiqong{
    public Wind(Class bc){
        this.health=75;
        this.attack=35;
        this.def=15;
        this.mana=200;
        this.speed=10;
        this.classname="Wind";

    }

}

class Earth extends Qiqong{
    public Earth(Class bd){
        this.health=100;
        this.attack=25;
        this.def=25;
        this.mana=150;
        this.speed=10;
        this.classname="Earth";

    }
}
