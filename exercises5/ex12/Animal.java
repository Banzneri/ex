public abstract class Animal {
    private String name;
    private boolean alive;
    private int healthAmount;

    public Animal(String name) {
        this.name = name;
        alive = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        alive = false;
    }

    public int getHealthAmount() {
        return healthAmount;
    }

    public void setHealthAmount(int healthAmount) {
        this.healthAmount = healthAmount;
    }

    public boolean eats(Animal animal) {
        if(this instanceof Human) {
            animal.die();
            setHealthAmount(healthAmount + 1);
            return true;
        } else if(this instanceof Dog && (animal instanceof Bird || animal instanceof Human)) {
            animal.die();
            setHealthAmount(healthAmount + 1);
            return true;
        } else {
            return false;
        }
    }
}