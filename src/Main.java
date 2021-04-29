import species.Unit;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IllegalClassFormatException, ClassNotFoundException, NoSuchFieldException {
        UnitFactory unitFactory = new UnitFactory();
        Unit u = unitFactory.createUnitByName(false,"Elf");
        unitFactory.callMethod(u);
        //unitFactory.makeInnerUnit(u);
        System.out.println(u.getNature());
        System.out.println(u.getAbility());
        System.out.println(u.getLifeExpectancy());
        Unit newU = unitFactory.createUnitByName(false,"Fairy");
        List<Unit> elf = unitFactory.getUnits(3, "Elf");
        elf.forEach(el->{
            System.out.println(el.getLifeExpectancy());
        });
        System.out.println(elf.get(1).getLifeExpectancy());
        //System.out.println(Arrays.toString(newU.getClass().getDeclaredFields()));
        //unitFactory.callMethod(newU);
    }
}
