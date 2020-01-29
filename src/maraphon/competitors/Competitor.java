package maraphon.competitors;

public interface Competitor {
    void run(int distance);
    void jump(int height);
    void swim(int dist);
    boolean isDistance();
    void info();
}
