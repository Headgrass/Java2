package maraphon.competitors;

public class Human implements Competitor {
    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean active;

    public Human(String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.active = true;
    }

    public Human(String name) {
        this(name, 2000, 1, 200);
        this.name = name;
    }

    @Override
    public void run(int dist) {
        if(dist <= maxRunDistance){
            System.out.println(name + " успешно пробежал");
        }else {
            System.out.println(name + " провалил тест на бег");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if(height <= maxJumpHeight){
            System.out.println(name + " успешно перепрыгнул");
        }else {
            System.out.println(name + " провалил тест на прыжок");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if(dist <= maxSwimDistance){
            System.out.println(name + " успешно проплыл");
        }else {
            System.out.println(name + " провалил тест на плавание");
            active = false;
        }
    }

    @Override
    public boolean isDistance() {
        return active;
    }

    @Override
    public void info() {
        System.out.println(name +" "+ active);
    }
}
