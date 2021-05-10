package istts.pbo.Players;

public class Equipment {
    private Head head;
    private Body body;
    private Boots boots;
    private Weapon weapon;
    private Accesories accesories;

    public Equipment() {
        this.head = null;
        this.body = null;
        this.boots = null;
        this.weapon = null;
        this.accesories = null;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Boots getBoots() {
        return boots;
    }

    public void setBoots(Boots boots) {
        this.boots = boots;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Accesories getAccesories() {
        return accesories;
    }

    public void setAccesories(Accesories accesories) {
        this.accesories = accesories;
    }
}
