import java.util.Objects;

/**
 * Created by Chevalier on 3/18/2017.
 */
public interface HeapInterface {
    public void add(Comparable newElement);     // Menambahkan elemen ke dalam heap tree
    public void print();                        // Menampilkan data dalam heap tree
    public Comparable peek();                   // Mengintip nilai dalam heap tree
    public Comparable remove(Object element);  // Menghapus elemen dalam heap tree
    public int size();                          // Mengambil ukuran dari heap tree
}
