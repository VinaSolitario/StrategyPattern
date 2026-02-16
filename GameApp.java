public class GameApp {

    public static void main(String[] args) {

        // Knight
        Character knight = new Character(
                new SwingSword(),
                new Shield()
        );

        System.out.println("Knight:");
        knight.performAttack();
        knight.performDefense();

        // Change Knight defense dynamically
        knight.setDefenseStrategy(new Dodge());
        knight.performDefense();

        System.out.println();

        // Wizard
        Character wizard = new Character(
                new CastSpell(),
                new CreateMagic()
        );

        System.out.println("Wizard:");
        wizard.performAttack();
        wizard.performDefense();

        System.out.println();

        // Archer
        Character archer = new Character(
                new ShootArrow(),
                new Dodge()
        );

        System.out.println("Archer:");
        archer.performAttack();
        archer.performDefense();
    }
}
