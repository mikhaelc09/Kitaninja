package istts.pbo.Classes;

public class Ninjutsu extends Job {
    public Ninjutsu(){
        super(80,25,15,0,30,100,0,"ninjutsu");
    }
}
class Kenjutsu extends Ninjutsu {
    public Kenjutsu(Job a){
        this.health=80;
        this.attack=25;
        this.def=15;
        this.mana=0;
        this.speed=30;
        this.classname="Kenjutsu";

    }
}

class Shurikenjutsu extends Ninjutsu {
    public Shurikenjutsu(Job b){
        this.health=85;
        this.attack=30;
        this.def=15;
        this.mana=0;
        this.speed=40;
        this.classname="Shurikenjutsu";

    }
}

class Kayakujutsu extends Ninjutsu {
    public Kayakujutsu(Job c){
        this.health=90;
        this.attack=30;
        this.def=15;
        this.mana=0;
        this.speed=35;
        this.classname="Kayakujutsu";

    }
}

class Shinobi extends Ninjutsu {
    public Shinobi(Job d){
        this.health=100;
        this.attack=25;
        this.def=15;
        this.mana=0;
        this.speed=30;
        this.classname="Shinobi";

    }
}
