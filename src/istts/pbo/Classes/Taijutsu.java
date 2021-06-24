package istts.pbo.Classes;

import istts.pbo.Enemy.StatEnemy;
import istts.pbo.Players.Stat;
import istts.pbo.Players.skilltrees.skills.*;

public class Taijutsu extends Job {
    @SuppressWarnings("unchecked")
    public Taijutsu(){
        super(new Stat(100,30,20,50,15,6,0,10),
                "Taijutsu", "Taijutsu", "src/istts/pbo/res/sprites/taijutsu.gif");
        this.getSkillTree().addSkill(new DamageOnly("Falcon Punch", "Taijutsu", "src/istts/pbo/res/IconSkill/Taijutsu-FalconPunch.png","Memukul dengan kecepatan Elang",getStats().getAttack()*150/100,3));
        this.getSkillTree().addSkill(new DamageOnly("Fus Ro Dah", "Taijutsu", "src/istts/pbo/res/IconSkill/Taijutsu-FusRoDah.png", "Berteriak keras untuk menyerang musuh",getStats().getAttack()*25/100,3));
        this.getSkillTree().addSkill(new DamageOnly("Konoha Senpu", "Taijutsu", "src/istts/pbo/res/IconSkill/Taijutsu-KonohaSenpu.png","Tendangan freestyle pada lawan",getStats().getAttack()*150/100,3));

        this.getSkillTree().addSkill(new DamageOnly("Naryeo Chagi","Taekwondo", "src/istts/pbo/res/IconSkill/Taekwondo-NaryeoChagi.png","Melakukan tendangan dari atas ke bawah mengenai kepala lawan",getStats().getAttack()*100/100,3));
        this.getSkillTree().addSkill(new DamageOnly("Kawi Chagi", "Taekwondo", "src/istts/pbo/res/IconSkill/Taekwondo-KawiChagi.png","Melompat dan melakukan tendangan ke samping",getStats().getAttack()*150/100,5));
        this.getSkillTree().addSkill(new DamageOnly("Dollyo Chagi", "Taekwondo","src/istts/pbo/res/IconSkill/Taekwondo-DollyoChagi.png","Melakukan putaran dan menendang ke atas",getStats().getAttack()*400/100,6));

        this.getSkillTree().addSkill(new DamageOnly("Fu Jow Pai", "Kungfu", "src/istts/pbo/res/IconSkill/Kungfu-FuJowPai.png","Mencakar musuh dimana setiap cakaran akan semakin sakit",getStats().getAttack()*120/100,2));
        this.getSkillTree().addSkill(new DamageOnly("One Inch Punch", "Kungfu", "src/istts/pbo/res/IconSkill/Kungfu-OneInchPunch.png","Memukul dengan jarak 1 inci",getStats().getAttack()*50/100,2));
        this.getSkillTree().addSkill(new Buff("Drunken Stance", "Kungfu", "src/istts/pbo/res/IconSkill/Kungfu-DrunkenStance.png","Masuk ke mode mabuk dengan minum arak cina",5,0,3,2));
        this.getSkillTree().addSkill(new DamageOnly("Nage Waza", "Aikido", "src/istts/pbo/res/IconSkill/Aikido-NageWaza.png","Melempar musuh dan menyebabkan stun",getStats().getAttack()*50/100,4));
        this.getSkillTree().addSkill(new DamageOnly("Uke Nagashi Irimi", "Aikido", "src/istts/pbo/res/IconSkill/Aikido-UkeNagashiIrimi.png","Mencounter serangan musuh",getStats().getAttack()*100/100,3));
        this.getSkillTree().addSkill(new DamageOnly("Kubishime", "Aikido", "src/istts/pbo/res/IconSkill/Aikido-Kubishime.png","Mencounter serangan musuh dan mencekik",getStats().getAttack()*10/100,6));// ini harusnya darihp musuh

        this.getSkillTree().addSkill(new DamageOnly("Harite", "Sumo", "src/istts/pbo/res/IconSkill/Sumo-Harite.png","Menampar dan menarget musuh",((getStats().getDefense()*50/100)+(getStats().getAttack()*50/100)),4));
        this.getSkillTree().addSkill(new DamageOnly("Body Slam", "Sumo", "src/istts/pbo/res/IconSkill/Sumo-BodySlam.png","Melempar badan untuk menindihi musuh",getStats().getHealth()*25/100,4));
        this.getSkillTree().addSkill(new Heal("Eat", "Sumo", "src/istts/pbo/res/IconSkill/Sumo-Eat.png","Makan untuk menambah nyawa",20,5));

        ((Skill)this.getSkillTree().getAt(0)).setUnlocked(true);
    }
}