# StrategyPattern

Problem scenario:

Suppose we have three types of characters in a GameApp:

1. Knight: Attacks with a sword; uses 3 strategies to defend (shield, dodge, magic barrier)
   
2. Wizard: Casts spells; uses magic barrier to defend
   
3. Archer: Shoots arrows; uses dodge to to defend

Implement two types of Strategy:

A.  DefenseStrategy

     1. Shield
	 
     2. Dodge
	 
     3. CreateMagic

B.  AttackStrategy

     1.  CastSpell
	 
     2.  ShootArrow
	 
     3.  SwingSword  


Refactor the existing codes and provide the UML Diagram:

public class Character {
    private String type;

    public Character(String type) {
        this.type = type;
    }

    public void attack() {
        if (type.equals("Knight")) {
            System.out.println("Knight attacks with a sword!");
        } else if (type.equals("Wizard")) {
            System.out.println("Wizard casts a spell!");
        } else if (type.equals("Archer")) {
            System.out.println("Archer shoots an arrow!");
        }
    }

    public void defend() {
        if (type.equals("Knight")) {
            System.out.println("Using a shield to defend!");
	System.out.println("Dodgin to avoid attack!");
            System.out.println("Creating a magic barrier for defense!"");		

        } else if (type.equals("Wizard")) {
            System.out.println("Creating a magic barrier for defense!"");
        } else if (type.equals("Archer")) {
            System.out.println("Using a shield to defend!"");
        }
    }
}

# STRATEGY PATTERN UML DIAGRAM
![input](https://github.com/VinaSolitario/StrategyPattern/blob/main/UML%20DIAGRAM.png)

# SOURCE CODE
AttackStrategy.java
public interface AttackStrategy {
    void attack();
}

CastSpell.java
public class CastSpell implements AttackStrategy {

    @Override
    public void attack() {
        System.out.println("Casting a spell!");
    }
}

Character.java
public class Character {

    private AttackStrategy attackStrategy;
    private DefenseStrategy defenseStrategy;

    public Character(AttackStrategy attackStrategy, DefenseStrategy defenseStrategy) {
        this.attackStrategy = attackStrategy;
        this.defenseStrategy = defenseStrategy;
    }

    public void performAttack() {
        attackStrategy.attack();
    }

    public void performDefense() {
        defenseStrategy.defend();
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void setDefenseStrategy(DefenseStrategy defenseStrategy) {
        this.defenseStrategy = defenseStrategy;
    }
}

CreateMagic.java
public class CreateMagic implements DefenseStrategy {

    @Override
    public void defend() {
        System.out.println("Creating a magic barrier for defense!");
    }
}

DefenseStrategy.java
public interface DefenseStrategy {
    void defend();
}

Dodge.java
public class Dodge implements DefenseStrategy {

    @Override
    public void defend() {
        System.out.println("Dodging to avoid attack!");
    }
}

GameApp.java
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

Shield.java
public class Shield implements DefenseStrategy {

    @Override
    public void defend() {
        System.out.println("Using a shield to defend!");
    }
}

ShootArrow.java
public class ShootArrow implements AttackStrategy {

    @Override
    public void attack() {
        System.out.println("Shooting an arrow!");
    }
}

SwingSword.java
public class SwingSword implements AttackStrategy {

    @Override
    public void attack() {
        System.out.println("Swinging a sword!");
    }
}

