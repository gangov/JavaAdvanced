package heroRepository;

import java.util.*;

public class HeroRepository {
    private HashMap<String, Hero> data;

    public HeroRepository() {
        this.data = new HashMap<>();
    }

    public void add(Hero entity) {
        data.put(entity.getName(), entity);
    }

    public void remove(String name) {
        data.remove(name);
    }

    public Hero getHeroWithHighestStrength() {
        Hero best = null;
        int str = Integer.MIN_VALUE;

        for (Hero hero : data.values()) {
            if (hero.getItem().getStrength() > str) {
                str = hero.getItem().getStrength();
                best = hero;
            }
        }
        return best;
    }


    public Hero getHeroWithHighestAgility() {
        Hero best = null;
        int aglt = Integer.MIN_VALUE;

        for (Hero hero : data.values()) {
            if (hero.getItem().getAgility() > aglt) {
                aglt = hero.getItem().getAgility();
                best = hero;
            }
        }
        return best;
    }

    public Hero getHeroWithHighestIntelligence() {
        Hero best = null;
        int intlgn = Integer.MIN_VALUE;

        for (Hero hero : data.values()) {
            if (hero.getItem().getIntelligence() > intlgn) {
                intlgn = hero.getItem().getIntelligence();
                best = hero;
            }
        }
        return best;
    }

    public int getCount() {
        return data.size();
    }

    @Override
    public String toString() {
        for (Hero hero : data.values()) {
            return hero.toString().trim();
        }
        return "";
    }
}
