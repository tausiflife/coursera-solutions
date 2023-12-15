package com.leetcode;

public class LivelockExample {
    static class Spoon {
        private Diner owner;

        public Spoon(Diner owner) {
            this.owner = owner;
        }

        public Diner getOwner() {
            return owner;
        }

        public synchronized void use() {
            System.out.println(owner.getName() + " is using the spoon.");
        }

        public synchronized void pass(Diner newOwner) {
            System.out.println(owner.getName() + " is passing the spoon to " + newOwner.getName());
            owner = newOwner;
        }
    }

    static class Diner {
        private String name;
        private boolean isHungry;

        public Diner(String name) {
            this.name = name;
            this.isHungry = true;
        }

        public String getName() {
            return name;
        }

        public boolean isHungry() {
            return isHungry;
        }

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                if (spoon.getOwner() != this) {
                    try {
                        System.out.println(name + " is not the owner, so sleeping...");
                        Thread.sleep(1000); // Simulate thinking
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                System.out.println(name + " is now the owner.");
                if (spouse.isHungry()) {
                    System.out.println(name + " sees that " + spouse.getName() + " is hungry, so waiting...");
                    spoon.pass(spouse);
                    continue;
                }

                spoon.use();
                isHungry = false;
                System.out.println(name + " has finished eating.");
                spoon.pass(spouse);
            }
        }
    }

    public static void main(String[] args) {
        final Diner husband = new Diner("Bob");
        final Diner wife = new Diner("Alice");

        final Spoon sharedSpoon = new Spoon(husband);

        new Thread(() -> husband.eatWith(sharedSpoon, wife)).start();
        new Thread(() -> wife.eatWith(sharedSpoon, husband)).start();
    }
}

