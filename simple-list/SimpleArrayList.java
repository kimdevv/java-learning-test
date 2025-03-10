import java.util.Arrays;

public class SimpleArrayList implements SimpleList {
    private String[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public SimpleArrayList() {
        this.array = new String[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    @Override
    public boolean add(String value) {
        ensureCapacity();
        array[size++] = value;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public String set(int index, String value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        String oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public boolean contains(String value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        int index = indexOf(value);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        String removedValue = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        return removedValue;
    }

    @Override
    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
    }
}
