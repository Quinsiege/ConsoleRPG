package com.company;

public class Weapon extends Item {
    public Weapon(int ID) {
        setID(ID);
        switch (getID ()) {
            case 1:
                setName("Алмазный меч");
                setType(Type.OneHandMaces);
                setSlot(Slot.MainHand);
                setLevel(1);
                setMinimalDamage(getLevel () * 13);
                setMaximumDamage(getLevel () * 15);
                setDroppable (true);
                break;
            case 2:
                setName("Бронзовый меч");
                setType(Type.OneHandMaces);
                setSlot(Slot.OffHand);
                setLevel(1);
                setMinimalDamage(getLevel () * 13);
                setMaximumDamage(getLevel () * 15);
                break;
            default:
                break;
        }
        setDPS ((float) (getLevel () * 1.5));
        setCategory (Category.Weapon);
        setLimitInStock (1);
        setRequireLevel (1);
        setDescription ("Тип: " + getType () + "<br/>" +
                        "Атака: " + getMinimalDamage () + " - " + getMaximumDamage () + "<br/>" +
                        "Уровень предмета: " + getLevel () + "<br/>" +
                        "Требуемый слот: " + getSlot());
    }

    public int getMinimalDamage() {
        return minimalDamage;
    }

    public void setMinimalDamage(int minimalDamage) {
        this.minimalDamage = minimalDamage;
    }

    public int getMaximumDamage() {
        return maximumDamage;
    }

    public void setMaximumDamage(int maximumDamage) {
        this.maximumDamage = maximumDamage;
    }

    private int ID;
    private int minimalDamage;
    private int maximumDamage;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
