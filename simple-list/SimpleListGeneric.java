public interface SimpleListGeneric<T> {

    static <T> SimpleArrayListGeneric<T> fromArrayToList(T[] values) {
        return new SimpleArrayListGeneric<>(values);
    }

    static <T extends Number> double sum(SimpleListGeneric<T> values) {
        double sum = 0;
        for (int i=0; i<values.size(); i++) {
            sum += values.get(i).doubleValue();
        }
        return sum;
    }

    static <T extends Number> SimpleArrayListGeneric<T> filterNegative(SimpleListGeneric<T> values) {
        SimpleArrayListGeneric<T> newArrayList = new SimpleArrayListGeneric<>();
        for(int i=0; i<values.size(); i++) {
            Number number = values.get(i);
            if (number.doubleValue() >= 0) {
                newArrayList.add((T)number);
            }
        }
        return newArrayList;
    }

    static <T> void copy(SimpleListGeneric<? extends T> from, SimpleListGeneric<T> to) {
        for (int i=0; i<from.size(); i++) {
            to.add(from.get(i));
        }
    }

    boolean add(T value);

    void add(int index, T value);

    T set(int index, T value);

    T get(int index);

    boolean contains(T value);

    int indexOf(T value);

    int size();

    boolean isEmpty();

    boolean remove(T value);

    T remove(int index);

    void clear();

}
