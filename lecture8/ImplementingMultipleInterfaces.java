package lec8;

class RealClass extends AA implements IA, IB {}
// the obligation to implement methodX is satisfied
// because an implementation is inherited from AA
class ImplementingMultipleInterfaces {
    public static void main (String[] a){
        RealClass rc = new RealClass();
        rc.methodX();
        //System.out.println(rc.consStr); // The compiler will
        // identify that the above line is ambiguous
        System.out.println(((IA)rc).consStr);
        System.out.println(((IB)rc).consStr);
    }
abstract class AA {
    public void methodX() { System.out.println("BOOM");}
}
interface IA {
    final static String consStr="Const of IA";
    void methodX();
}
interface IB {
    final static String consStr="Const of IB";
    void methodX();
}
interface IC extends IA, IB {};
// an interface can extend >1 other interfaces