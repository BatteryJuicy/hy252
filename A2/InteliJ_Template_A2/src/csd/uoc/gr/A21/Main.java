package csd.uoc.gr.A21;

public class Main {
    public static void main(String[] args) {
        SolidShape s = new SolidShape(5, 0, 0);
        System.out.println(s.toString());
        Sphere sphere = new Sphere(6, 7, 8, 10);
        System.out.println(sphere.toString());
        Cube cube = new Cube(10, 10, 10, 10);
        System.out.println(cube.toString());
        Cylinder cylinder = new Cylinder(3, 3, 3, 5, 10);
        System.out.println(cylinder.toString());
    }
}
