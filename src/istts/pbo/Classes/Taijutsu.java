package istts.pbo.Classes;

public class Taijutsu extends Job {
    public Taijutsu(){
        super(100,30,20,50,15,1,0,0,"Taijutsu");
    }
}
class Taekwondo extends Taijutsu {
    public Taekwondo(Job ab){
        this.health=90;
        this.attack=30;
        this.def=20;
        this.mana=50;
        this.speed=15;
        this.classname="Taekwondo";

    }
}

class Kungfu extends Taijutsu {
    public Kungfu(Job ac){
        this.health=110;
        this.attack=30;
        this.def=15;
        this.mana=60;
        this.speed=30;
        this.classname="Kungfu";

    }
}

class Aikido extends Taijutsu {
    public Aikido(Job ad){
        this.health=140;
        this.attack=25;
        this.def=35;
        this.mana=60;
        this.speed=30;
        this.classname="Aikido";

    }
}

class Sumo extends Taijutsu {
    public Sumo(Job ae){
        this.health=180;
        this.attack=15;
        this.def=35;
        this.mana=50;
        this.speed=15;
        this.classname="Sumo";

    }
}