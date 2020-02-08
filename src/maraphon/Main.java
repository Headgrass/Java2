package maraphon;

import maraphon.competitors.*;
import maraphon.obstacle.Cross;
import maraphon.obstacle.Obstacle;
import maraphon.obstacle.Wall;
import maraphon.obstacle.Water;
// проверка
public class Main {
    public static void main(String[] args) {
        Competitor[] competitors ={
                new Human("Vasya"),
                new Cat("Barsik"),
                new Dog("Tuzik"),
                new Cat("Murzik"),
                new Robot("010101")
        };
        Obstacle[] obstacles ={
          new Wall(5),
          new Water(10),
          new Cross(500)
        };
        for (Competitor c:competitors){
            for(Obstacle o:obstacles){
                o.doIt(c);
                if(!c.isDistance()){
                    break;
                }
            }
        }
        for(Competitor c:competitors){
            c.info();
        }
    }
}
