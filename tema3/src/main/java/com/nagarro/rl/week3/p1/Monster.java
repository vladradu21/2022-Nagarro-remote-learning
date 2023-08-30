package com.nagarro.rl.week3.p1;

public abstract class Monster extends Character implements CharacterActions{
    private String race;

    public Monster(String race, int life, int attack, int defense) {
        super(life, attack, defense);
        this.race = race;
    }

    public String getRace() {
        return race;
    }

    @Override
    public String toString() {
        return "Mosters race= " + race + super.toString();
    }

    @Override
    public void attack(Character character) {
        if(character instanceof Hero) {
            if(character.getLife() <= 0) {
                System.out.println(((Hero) character).getName() + " is dead");
            } else {
                System.out.println(race + " attacks " + ((Hero) character).getName());
                character.setLife(character.getLife() + Math.min(character.getDefense() - this.getAttack(), 0));
            }
        } else {
            System.out.println(race + " can't attack another monster!");
        }

        System.out.println(character.toString());
        System.out.println(this);
    }

    public abstract void useMagicalSkills();
}
