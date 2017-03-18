import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Chevalier on 3/18/2017.
 */
public class HeapTreeMax implements HeapInterface {
    // Wadah penyimpan data
    ArrayList<Comparable> elements;

    // Contructor
    public HeapTreeMax(ArrayList<Comparable> elements) {
        this.elements = new ArrayList<>();
        this.elements.add(null);
    }

    @Override
    public void add(Comparable newElement) {
        elements.add(0);

        int index = elements.size() - 1;
        // bukan root dan nilai baru lebih besar dari parent
        while (index > 1 && getParent(index).compareTo(newElement) < 0){
            elements.set(index, getParent(index));
            index = getParentChildIndex(index);
        }
        elements.set(index, newElement);
    }

    @Override
    public void print() {

    }

    @Override
    public Comparable peek() {
        return null;
    }

    @Override
    public Comparable remove(Object element) {
        int deletingIndex = elements.indexOf(element);
        int lastIndex = elements.size()-1;
        Comparable last = elements.get(lastIndex);
        Comparable remove = elements.get(deletingIndex);
        elements.remove(lastIndex);

        if (deletingIndex >= 1 && deletingIndex < lastIndex){
            elements.set(deletingIndex, last);
            maxHeap(deletingIndex);
        }
        return remove;
    }

    @Override
    public int size() {
        return elements.size();
    }

    private void maxHeap(int index){
        Comparable root = elements.get(index);

        int lastIndex = elements.size()-1;
        if (getLeftChildIndex(index) > (lastIndex-1)){
            return;
        }
        boolean more = true;
        while (more){
            int childIndex = getLeftChildIndex(index);
            int comp;
            Comparable temp;

            if (getParent(index) != null){
                comp = getParent(index).compareTo(elements.get(index));
                if (comp>0){
                    temp = getParent(index);
                    elements.set(getParentChildIndex(index), elements.get(index));
                    elements.set(index, temp);
                }
            }

            // Get Smaller Child
            if (childIndex <= lastIndex){
                // get left child first
                Comparable child = getLeftChild(index);

                // Use right child instead if it is smaller
                if (getRightChildIndex(index) <= lastIndex &&
                        getRightChild(index).compareTo(child) < 0){
                    childIndex = getRightChildIndex(index);
                    child = getRightChild(index);
                }
                if (child.compareTo(root)<0){
                    elements.set(index, child);
                    index = childIndex;
                } else {
                    more = false;
                }
                elements.set(index, root);
            } else {
                more = false;
            }
        }
    }

    private static int getLeftChildIndex(int index){
        return 2 * index;
    }

    private static int getRightChildIndex(int index){
        return 2 * index + 1;
    }

    private static int getParentChildIndex(int index){
        return index / 2;
    }

    private Comparable getLeftChild(int index){
        return elements.get(getLeftChildIndex(index));
    }

    private Comparable getRightChild(int index){
        return elements.get(getRightChildIndex(index));
    }

    private Comparable getParent(int index){
        return elements.get(getParentChildIndex(index));
    }
}
