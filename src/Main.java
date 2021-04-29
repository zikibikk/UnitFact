import species.Unit;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IllegalClassFormatException, ClassNotFoundException, NoSuchFieldException {
        UnitFactory unitFactory = new UnitFactory();
        Unit u = unitFactory.createUnit("Elf");
        Unit f = unitFactory.createUnit("Fairy");
        System.out.println(f.getInner());
        System.out.println(u.getNature());
        System.out.println(u.getAbility());
        System.out.println(u.getLifeExpectancy());
        List<Unit> elf = unitFactory.getUnits(3, "Elf");
        elf.forEach(el->{
            System.out.println(el.getInner());
        });
        u.getInner();
    }
}
