package istts.pbo.Players;

public abstract class Item {
    private String name;
    private int stat;
    private int cost;
    private String spritePath;

    public Item(String name, int stat, int cost, String spritePath) {
        this.name = name;
        this.stat = stat;
        this.cost = cost;
        this.spritePath = spritePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStat() {
        return stat;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public String getSpritePath() {
        return spritePath;
    }

    public void setSpritePath(String spritePath) {
        this.spritePath = spritePath;
    }
}