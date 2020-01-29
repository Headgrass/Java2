package maraphon.competitors;

public class Animal implements Competitor {
    String type;
    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }



    @Override
    public void run(int dist) {
        if(dist <= maxRunDistance){
            System.out.println(type +" "+ name + " успешно пробежала");
        }else {
            System.out.println(type +" "+ name + " провалила тест на бег");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if(height <= maxJumpHeight){
            System.out.println(type +" "+ name + " успешно перепрыгнула");
        }else {
            System.out.println(type +" "+ name + " провалила тест на прыжок");
            onDistance = false;
        }
    }

    @Override
    public void swim(int dist) {
        if(dist <= maxSwimDistance){
            System.out.println(type +" "+ name + " успешно проплыла");
        }else {
            System.out.println(type +" "+ name + " провалила тест на плавание");
            onDistance = false;
        }
    }

    @Override
    public boolean isDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(type + " "+ name +" "+onDistance);
    }
}
