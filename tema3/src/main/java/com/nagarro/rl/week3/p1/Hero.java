package com.nagarro.rl.week3.p1;

public class Hero extends Character implements CharacterActions{
    private String name;
    private int xp;

    public Hero(String name, int xp, int life, int attack, int defense) {
        super(life, attack, defense);
        this.name = name;
        this.xp = xp;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Hero name= " + name + ", xp= " + xp + super.toString();
    }

    @Override
    public void attack(Character character) {
        if(character instanceof Monster) {
            if(character.getLife() <= 0) {
                System.out.println(((Monster) character).getRace() + " is dead!");
                xp += 10;
            } else {
                System.out.println(name + " attacks " + ((Monster) character).getRace());
                character.setLife(character.getLife() + Math.min(character.getDefense() - this.getAttack(), 0));
                xp += 2;
            }
        } else {
            System.out.println(this.getName() + " can't attack another hero!");
        }

        System.out.println(this);
        System.out.println(character.toString());
    }
}
