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

    /*public void generate_nature(){
        switch (((int) Math.random()*5)%2) {
            case 0 -> this.nature = Nature.MILITANT;
            case 1 -> this.nature = Nature.PEACEFUL;
        }
    }*/

    /*public void generate_character(){
        switch ((int) (Math.random() * 4)) {
            case 0 -> this.character = Character.ANGRY;
            case 1 -> this.character = Character.GENEROUS;
            case 2 -> this.character = Character.IRSCIBLE;
            case 3 -> this.character = Character.MERCIFUL;
            default -> this.character = Character.STRICT;
        }
    }*/
}
