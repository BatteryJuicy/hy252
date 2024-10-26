package csd.uoc.gr.A21;


public class SolidShape {
    private float x = 0;
    private float y = 0;
    private float z = 0;

    SolidShape(float x, float y, float z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    //setters
    void setX(float x) {
        this.x = x;
    }
    void setY(float y) {
        this.y = y;
    }
    void setZ(float z) {
        this.z = z;
    }

    //getters
    int getNumberOfFaces() {
        return 0;
    }
    int getNumberOfVertices() {
        return 0;
    }
    int getNumberOfEdges() {
        return 0;
    }
    float getVolume(){
        return 0;
    }

    public String toString(){
        String str = "Solid shape centered at (" + x + ", " + y + ", " + z + ") with\n";
        str += "faces: " + getNumberOfFaces() + "\n";
        str += "vertices: " + getNumberOfVertices() + "\n";
        str += "edges: " + getNumberOfEdges() + "\n";
        str += "volume: " + getVolume() + "\n";
        return str;
    }
}

class Sphere extends SolidShape {
    private float radius;

    Sphere(int x, int y, int z, float radius) {
        super(x, y, z);
        this.radius = radius;
    }

    @Override
    int getNumberOfFaces() {
        return 1;
    }

    @Override
    float getVolume() {
        return (float) ((float)(4/3) * Math.PI * Math.pow(radius, 2));
    }

    public String toString(){
        String str = "Sphere ";
        str += super.toString();
        str += "radius: " + radius + "\n";
        return str;
    }
}

class Cube extends SolidShape {
    private float side = 1;

    Cube(int x, int y, int z, float side) {
        super(x, y, z);
        this.side = side;
    }

    float getSide(){
        return side;
    }

    int getNumberOfFaces() {
        return 6;
    }
    int getNumberOfVertices() {
        return 8;
    }
    int getNumberOfEdges() {
        return 12;
    }
    float getVolume(){
        return (float) Math.pow(side, 3);
    }

    public String toString(){
        String str = "Cube ";
        str += super.toString();
        str += "side: " + side + "\n";
        return str;
    }
}

class Cylinder extends SolidShape {
    private float radius;
    private float height;

    Cylinder(int x, int y, int z, float radius, float height) {
        super(x, y, z);
        this.radius = radius;
        this.height = height;
    }

    float getRadius(){
        return radius;
    }
    float getHeight(){
        return height;
    }
    int getNumberOfFaces() {
        return 3;
    }
    int getNumberOfEdges(){
        return 2;
    }
    float getVolume(){
        return (float) (Math.PI * Math.pow(radius, 2) * height);
    }

    public String toString(){
        String str = "Cylinder ";
        str += super.toString();
        str += "radius: " + radius + "\n";
        str += "height: " + height + "\n";
        return str;
    }

}