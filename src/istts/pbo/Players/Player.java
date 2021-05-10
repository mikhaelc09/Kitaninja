package istts.pbo.Players;

import istts.pbo.Classes.Job;
import istts.pbo.Players.skilltrees.skills.Skill;

import java.util.ArrayList;

public class Player {

    private String name;
    private int gold;
    private int level;
    private int xp;
    private Job playerClass;
    private Equipment equipment;
    private ArrayList<Item> items;
    private ArrayList<Skill> unlockedSkills;
    private ArrayList<Skill> equippedSkills;

    public Player(String name, int gold, int level, int xp, Job playerClass) {
        this.name = name;
        this.gold = gold;
        this.level = level;
        this.xp = xp;
        this.playerClass = playerClass;
        equipment = new Equipment();
        items = new ArrayList<Item>();
        unlockedSkills = new ArrayList<Skill>();
        equippedSkills = new ArrayList<Skill>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Job getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(Job playerClass) {
        this.playerClass = playerClass;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Skill> getUnlockedSkills() {
        return unlockedSkills;
    }

    public void setUnlockedSkills(ArrayList<Skill> unlockedSkills) {
        this.unlockedSkills = unlockedSkills;
    }

    public ArrayList<Skill> getEquippedSkills() {
        return equippedSkills;
    }

    public void setEquippedSkills(ArrayList<Skill> equippedSkills) {
        this.equippedSkills = equippedSkills;
    }
}
