package istts.pbo.Players;

public class Equipment {
    private Helmet head;
    private Body body;
    private Boots boots;
    private Weapon weapon;
    private Accesories accesories;

    public Equipment() {
        this.head = new Helmet("-",0,0,"src/istts/pbo/res/Item/Blank.png");
        this.body = new Body("-",0,0,"src/istts/pbo/res/Item/Blank.png");
        this.boots = new Boots("-",0,0,"src/istts/pbo/res/Item/Blank.png");
        this.weapon = new Weapon("-",0,0,"src/istts/pbo/res/Item/Blank.png");
        this.accesories = new Accesories("-",0,0,"src/istts/pbo/res/Item/Blank.png");
    }

    public Helmet getHead() {
        return head;
    }

    public void setHead(Helmet head) {
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
