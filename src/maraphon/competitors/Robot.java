package maraphon.competitors;

public class Robot implements Competitor {
    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean active;

    public Robot(String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.active = true;
    }

    public Robot(String name) {
        this(name, 5000, 20, 0);
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
