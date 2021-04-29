package species;

enum Nature{
    PEACEFUL,
    MILITANT
}

enum Ability{
    HEALING,
    FLYING,
    FIREBALLS
}

enum Character{
    IRSCIBLE,
    MERCIFUL,
    ANGRY,
    GENEROUS,
    STRICT
}

public abstract class Unit {

    public Unit(String name, Ability ability) {
        this.name = name;
        this.ability = ability;
    }

    String name;
    Ability ability;

    public Ability getAbility() {
        return ability;
    }

    public abstract Nature getNature();

    public abstract Integer getLifeExpectancy();

    public Unit getInner(){return null;}

}
