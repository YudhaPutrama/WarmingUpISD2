public class Main {

    public static void main(String[] args) {
	    HeapTreeMin hpm = new HeapTreeMin();
        hpm.add(5);
//        hpm.print();
        hpm.add(3);
//        hpm.print();
        hpm.add(9);
//        hpm.print();
        hpm.add(6);
//        hpm.print();
        hpm.add(4);
//        hpm.print();
        hpm.add(1);
//        hpm.print();
        hpm.add(8);
//        hpm.print();
        hpm.add(11);
        System.out.print("Nilai awal Heap Tree  : ");
        hpm.print();
        System.out.println();
        hpm.remove(3);
        System.out.println();
        System.out.print("Nilai akhir Heap Tree : ");
        hpm.print();
    }
}
