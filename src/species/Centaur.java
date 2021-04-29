package species;

public class Centaur extends Unit{
    public Centaur() {
        super("Cento", Ability.FIREBALLS);
    }

    @Override
    public Nature getNature() {
        return null;
    }

    @Override
    public Integer getLifeExpectancy() {
        return null;
    }
}
