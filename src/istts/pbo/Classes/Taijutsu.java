package istts.pbo.Classes;

import istts.pbo.Players.Stat;
import istts.pbo.Players.skilltrees.skills.Buff;
import istts.pbo.Players.skilltrees.skills.DamageOnly;
import istts.pbo.Players.skilltrees.skills.Skill;

public class Taijutsu extends Job {
    @SuppressWarnings("unchecked")
    public Taijutsu(){
        super(new Stat(100,30,20,50,15,0,0,10),
                "Taijutsu", "Taijutsu", "src/istts/pbo/res/sprites/taijutsu.gif");
        this.getSkillTree().addSkill(new DamageOnly("Falcon Punch", "Taijutsu", "src/istts/pbo/res/IconSkill/Taijutsu-FalconPunch.png","Memukul dengan kecepatan Elang"));
        this.getSkillTree().addSkill(new DamageOnly("Fus Ro Dah", "Taijutsu", "src/istts/pbo/res/IconSkill/Taijutsu-FusRoDah.png", "Berteriak keras untuk menyerang musuh"));
        this.getSkillTree().addSkill(new DamageOnly("Konoha Senpu", "Taijutsu", "src/istts/pbo/res/IconSkill/Taijutsu-KonohaSenpu.png","Tendangan freestyle pada lawan"));

        this.getSkillTree().addSkill(new DamageOnly("Naryeo Chagi","Taekwondo", "src/istts/pbo/res/IconSkill/Taekwondo-NaryeoChagi.png","Melakukan tendangan dari atas ke bawah mengenai kepala lawan"));
        this.getSkillTree().addSkill(new DamageOnly("Kawi Chagi", "Taekwondo", "src/istts/pbo/res/IconSkill/Taekwondo-KawiChagi.png","Melompat dan melakukan tendangan ke samping"));
        this.getSkillTree().addSkill(new DamageOnly("Dollyo Chagi", "Taekwondo","src/istts/pbo/res/IconSkill/Taekwondo-DollyoChagi.png","Melakukan putaran dan menendang ke atas"));

        this.getSkillTree().addSkill(new DamageOnly("Fu Jow Pai", "Kungfu", "src/istts/pbo/res/IconSkill/Kungfu-FuJowPai.png","Mencakar musuh dimana setiap cakaran akan semakin sakit"));
        this.getSkillTree().addSkill(new DamageOnly("One Inch Punch", "Kungfu", "src/istts/pbo/res/IconSkill/Kungfu-OneInchPunch.png","Memukul dengan jarak 1 inci"));
        this.getSkillTree().addSkill(new Buff("Drunken Stance", "Kungfu", "src/istts/pbo/res/IconSkill/Kungfu-DrunkenStance.png","Masuk ke mode mabuk dengan minum arak cina"));

        this.getSkillTree().addSkill(new DamageOnly("Nage Waza", "Aikido", "src/istts/pbo/res/IconSkill/Aikido-NageWaza.png","Melempar musuh dan menyebabkan stun"));
        this.getSkillTree().addSkill(new DamageOnly("Uke Nagashi Irimi", "Aikido", "src/istts/pbo/res/IconSkill/Aikido-UkeNagashiIrimi.png","Mencounter serangan musuh"));
        this.getSkillTree().addSkill(new DamageOnly("Kubishime", "Aikido", "src/istts/pbo/res/IconSkill/Aikido-Kubishime.png","Mencounter serangan musuh dan mencekik"));

        this.getSkillTree().addSkill(new DamageOnly("Harite", "Sumo", "src/istts/pbo/res/IconSkill/Sumo-Harite.png","Menampar dan menarget musuh"));
        this.getSkillTree().addSkill(new DamageOnly("Body Slam", "Sumo", "src/istts/pbo/res/IconSkill/Sumo-BodySlam.png","Melempar badan untuk menindihi musuh"));
        this.getSkillTree().addSkill(new Buff("Eat", "Sumo", "src/istts/pbo/res/IconSkill/Sumo-Eat.png","Makan untuk menambah nyawa"));

        ((Skill)this.getSkillTree().getAt(0)).setUnlocked(true);
    }
}
class Taekwondo extends Taijutsu {
    public Taekwondo(Job ab){
        getStats().setHealth(90);
        getStats().setAttack(30);
        getStats().setDefense(20);
        getStats().setMana(50);
        getStats().setSpeed(15);
        setClassname("Taekwondo");
    }
}

class Kungfu extends Taijutsu {
    public Kungfu(Job ac){
        getStats().setHealth(110);
        getStats().setAttack(30);
        getStats().setDefense(15);
        getStats().setMana(60);
        getStats().setSpeed(30);
        setClassname("Kungfu");
    }
}

class Aikido extends Taijutsu {
    public Aikido(Job ad){
        getStats().setHealth(140);
        getStats().setAttack(25);
        getStats().setDefense(35);
        getStats().setMana(60);
        getStats().setSpeed(30);
        setClassname("Aikido");
    }
}

class Sumo extends Taijutsu {
    public Sumo(Job ae){
        getStats().setHealth(180);
        getStats().setAttack(15);
        getStats().setDefense(35);
        getStats().setMana(50);
        getStats().setSpeed(15);
        setClassname("Sumo");
    }
}