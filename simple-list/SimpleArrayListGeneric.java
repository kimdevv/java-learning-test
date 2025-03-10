import java.util.Arrays;

public class SimpleArrayListGeneric<T> implements SimpleListGeneric<T> {
    private T[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public SimpleArrayListGeneric() {
        this.array = (T[])new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public SimpleArrayListGeneric(T... args) {
        this.array = args;
        this.size = this.array.length;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    @Override
    public boolean add(T value) {
        ensureCapacity();
        array[size++] = value;
        return true;
    }

    @Override
    public void add(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public T set(int index, T value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        T oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {
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
    public boolean remove(T value) {
        int index = indexOf(value);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        T removedValue = array[index];
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
