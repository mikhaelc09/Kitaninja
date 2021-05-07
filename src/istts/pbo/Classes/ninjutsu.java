package istts.pbo.Classes;

public class ninjutsu extends Class{
    public ninjutsu(int health, int attack, int def, int mana, int speed, int lvl, int acc, int critrate, String classname) {
        super(health, attack, def, mana, speed, lvl, acc, critrate, classname);
    }
    public ninjutsu(){
        super(80,25,15,0,30,1,100,0,"ninjutsu");
    }
}
class Kenjutsu extends ninjutsu {
    public Kenjutsu(Class a){
        this.health=80;
        this.attack=25;
        this.def=15;
        this.mana=0;
        this.speed=30;
        this.classname="Kenjutsu";

    }
}

class Shurikenjutsu extends ninjutsu{
    public Shurikenjutsu(Class b){
        this.health=85;
        this.attack=30;
        this.def=15;
        this.mana=0;
        this.speed=40;
        this.classname="Shurikenjutsu";

    }
}

class Kayakujutsu extends ninjutsu{
    public Kayakujutsu(Class c){
        this.health=90;
        this.attack=30;
        this.def=15;
        this.mana=0;
        this.speed=35;
        this.classname="Kayakujutsu";

    }
}

class Shinobi extends ninjutsu{
    public Shinobi(Class d){
        this.health=100;
        this.attack=25;
        this.def=15;
        this.mana=0;
        this.speed=30;
        this.classname="Shinobi";

    }
}
