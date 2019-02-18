package com.designpattern.creational.prototype;

import javafx.geometry.Point3D;

/**
 * Prototype ?
 * - We have a complex object that is costly to create. To create more instance to such class we use an existing instance as our prototype.
 *
 *  Client    ------------> Abstract
 *                          Prototype
 *                         /        \
 *               ConcreteProtA     ConcreteProtoB
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Swordman s1 = new Swordman();
        s1.move(new Point3D(-10, 0,0), 20 );
        s1.attack();
        System.out.println(s1);

        Swordman s2 = (Swordman) s1.clone();
        System.out.println("Cloned swards " + s2);
    }
}
class General extends GameUnit {
    private String state = "idle";

    public void boostMorale(){
        this.state = "MoralBoost";
    }

    @Override
    public String toString() {
        return "General{" + "state='" + state + '\'' + '}';
    }

    @Override
    protected void reset() {
        throw new UnsupportedOperationException("Reset not supported");
    }

    @Override
    protected GameUnit clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Generals are unique");
    }
}

class Swordman extends GameUnit{
    private String state = "idle";
    public void attack(){
        this.state = "attack";
    }

    @Override
    public String toString() {
        return "Swordman{" + "state='" + state + '\'' + '}';
    }

    @Override
    protected void reset() {
        state = "idle";
    }
}

abstract class GameUnit implements Cloneable{
    private Point3D position;

    public GameUnit(){
        position = Point3D.ZERO;
    }

    @Override
    protected GameUnit clone() throws CloneNotSupportedException {
        GameUnit unit = (GameUnit) super.clone();
        unit.initialize();
        return unit;
    }

    protected void initialize(){
        this.position = Point3D.ZERO;
        reset();
    }

    protected abstract void reset();

    public GameUnit(float x, float y, float z) {
        position = new Point3D(x,y, z);
    }

    public void move(Point3D direction, float distance) {
        Point3D finalMove = direction.normalize();
        finalMove = finalMove.multiply(distance);
        position = position.add(finalMove);
    }

    public Point3D getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "GameUnit{" +
                "position=" + position +
                '}';
    }
}