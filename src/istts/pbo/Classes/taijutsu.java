package istts.pbo.Classes;

public class taijutsu extends Class{
    public taijutsu(int health, int attack, int def, int mana, int speed, int lvl, int acc, int critrate, String classname) {
        super(health, attack, def, mana, speed, lvl, acc, critrate, classname);
    }
    public taijutsu(){
        super(100,30,20,50,15,1,0,0,"Taijutsu");
    }
}
class Taekwondo extends taijutsu{
    public Taekwondo(Class ab){
        this.health=90;
        this.attack=30;
        this.def=20;
        this.mana=50;
        this.speed=15;
        this.classname="Taekwondo";

    }
}

class Kungfu extends taijutsu{
    public Kungfu(Class ac){
        this.health=110;
        this.attack=30;
        this.def=15;
        this.mana=60;
        this.speed=30;
        this.classname="Kungfu";

    }
}

class Aikido extends taijutsu{
    public Aikido(Class ad){
        this.health=140;
        this.attack=25;
        this.def=35;
        this.mana=60;
        this.speed=30;
        this.classname="Aikido";

    }
}

class Sumo extends taijutsu{
    public Sumo(Class ae){
        this.health=180;
        this.attack=15;
        this.def=35;
        this.mana=50;
        this.speed=15;
        this.classname="Sumo";

    }
}