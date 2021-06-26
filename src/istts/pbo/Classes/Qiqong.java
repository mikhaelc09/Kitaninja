package istts.pbo.Classes;

import istts.pbo.Players.Stat;
import istts.pbo.Players.skilltrees.SkillTree;
import istts.pbo.Players.skilltrees.skills.*;

public class Qiqong extends Job {
    @SuppressWarnings("unchecked")
    public Qiqong() {
        super(new Stat(70,100,15,150,10,6,0,10),
                "Qiqong", "Qiqong", "src/istts/pbo/res/sprites/qigong.gif");
        this.getSkillTree().addSkill(new DamageOnly("Hadouken", "Qiqong", "src/istts/pbo/res/IconSkill/Qiqong-Hadouken.png","Melempar sebuah bola energi",20,20));
        this.getSkillTree().addSkill(new Mana("Calm Mind",  "Qiqong", "src/istts/pbo/res/IconSkill/Qiqong-CalmMind.png","Menambah Mana",20));
        this.getSkillTree().addSkill(new DamageOnly("Kamehameha", "Qiqong", "src/istts/pbo/res/IconSkill/Qiqong-Kamehameha.png","Mengumpulkan Mana untuk menyerang musuh dengan bom ki",60,40));

        this.getSkillTree().addSkill(new DamageOnly("Hinotama", "Fire", "src/istts/pbo/res/IconSkill/Fire-Hinotama.png","Melemparkan sebuah bola api besar",50,20));
        this.getSkillTree().addSkill(new Buff("Heatblast Form",  "Fire", "src/istts/pbo/res/IconSkill/Fire-Heatblast.png","Menyatukan wujud api dengan diri untuk menambah kekuatan",2,30,5,50));
        this.getSkillTree().addSkill(new DamageOnly("Explosion","Fire","src/istts/pbo/res/IconSkill/Fire-Explosion.png","Mengeluarkan ledakan besar dengan seluruh mana",getStats().getMana(),getStats().getMana()));

        this.getSkillTree().addSkill(new DamageOnly("Rasengan", "Wind", "src/istts/pbo/res/IconSkill/Wind-Rasengan.png","Membuat pusaran angin di telapak tangan untuk menyakiti musuh",30,20));
        this.getSkillTree().addSkill(new Buff("Wind of Nature", "Wind", "src/istts/pbo/res/IconSkill/Wind-WindOfNature.png","Memperkuat diri dengan elemen angin untuk menambah speed",3,10,3,20));
        this.getSkillTree().addSkill(new DamageOnly("Divine Sandstorm", "Wind", "src/istts/pbo/res/IconSkill/Wind-DivineSandstorm.png","Membuat 2 tornado di masing masing tangan dengan arah berbeda untuk mencabik musuh",100,80));

        this.getSkillTree().addSkill(new DamageOnly("Mystic Snake", "Water", "src/istts/pbo/res/IconSkill/Water-MysticSnake.png","Membuat inkarnasi ular yang melukai musuh",30,20));
        this.getSkillTree().addSkill(new DamageOnly("Water Prison", "Water", "src/istts/pbo/res/IconSkill/Water-WaterPrison.png", "Membuat penjara air untuk menghabiskan oksigen musuh",60,30));
        this.getSkillTree().addSkill(new StatusEffect("Daiguren Hyoinmaru", "Water","src/istts/pbo/res/IconSkill/Water-DaigurenHyorinmaru.png","Membuat naga es yang membekukan musuh",3,1,2,70));

        this.getSkillTree().addSkill(new StatusEffect("Sand Attack", "Earth", "src/istts/pbo/res/IconSkill/Sand-SandThrow.png","Melemparkan pasir untuk membutakan musuh",1,50,1,20));
        this.getSkillTree().addSkill(new StatusEffect("Summon Thwomp", "Earth", "src/istts/pbo/res/IconSkill/Sand-SummonTwhomp.png","Mensummon batu berduri yang bisa stun musuh",3,100,1,20));
        this.getSkillTree().addSkill(new Buff("Harden", "Earth", "src/istts/pbo/res/IconSkill/Sand-Harden.png","Memperkeras diri untuk meningkatkan defense",4,50,5,30));

        ((Skill)this.getSkillTree().getAt(0)).setUnlocked(true);
    }
}