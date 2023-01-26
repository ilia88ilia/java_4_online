package ua.com.illia;

import java.util.*;

public class MatList<E extends Number> implements List<E> {
    private final int SIZE = 10;
    int size;
    private Object[] array = new Object[SIZE];

    public MatList() {
        size = 0;
    }

    public MatList(E[]... numbers) {

        for (E[] number : numbers) {
            add(number);
        }
    }

    public MatList(MatList... numbers) {

        MatList newMatlist = new MatList();
        if (numbers.length > 1)
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = 0; j < numbers[i + 1].size(); j++) {
                    numbers[i].add((E) numbers[i + 1].array[j]);
                }
                numbers[i + 1] = numbers[i];
                newMatlist = numbers[i + 1];
            }
        else {
            newMatlist = numbers[0];
        }
        this.size = newMatlist.size;
        this.array = Arrays.copyOf(newMatlist.array, newMatlist.size);
    }

    public void add(E... numbers) {

        for (int i = 0; i < numbers.length; i++) {
            add(numbers[i]);
        }
    }

    public void join(MatList... ml) {

        MatList newMatlist = new MatList(ml);

        for (int i = 0; i < newMatlist.size(); i++) {
            this.add((E) newMatlist.array[i]);
        }
    }

    public void intersection(MatList... ml) {
        for (MatList newMatlist : ml) {
            this.retainAll(newMatlist);
        }
    }

    public void sortDesc() {
        Number[] s = new Number[size];
        s = this.toArray();
        Collections.sort(Arrays.asList(s), Collections.reverseOrder());
        this.array = Arrays.copyOf(s, size);
    }

    public void sortDesc(E value) {
        Number[] s = new Number[size];
        s = this.toArray();
        int fromIndex = this.indexOf(value);
        int toIndex = this.size() - 1;
        this.sortDesc(fromIndex, toIndex);
    }

    public void sortDesc(int fromIndex, int toIndex) {
        Number[] s = new Number[toIndex - fromIndex + 1];
        s = this.toArray(fromIndex, toIndex);
        Collections.sort(Arrays.asList(s), Collections.reverseOrder());
        int k = 0;
        for (int i = fromIndex; i < toIndex + 1; i++) {
            this.set(i, (E) s[k]);
            k++;
        }
    }

    public void sortAsc() {
        Number[] s = new Number[size];
        s = this.toArray();
        Arrays.sort(s);
        this.array = Arrays.copyOf(s, size);
    }

    public void sortAsc(E value) {
        Number[] s = new Number[size];
        s = this.toArray();
        int fromIndex = this.indexOf(value);
        int toIndex = this.size() - 1;
        this.sortAsc(fromIndex, toIndex);
    }

    public void sortAsc(int fromIndex, int toIndex) {
        Number[] s = new Number[toIndex - fromIndex + 1];
        s = this.toArray(fromIndex, toIndex);
        Arrays.sort(s);
        int k = 0;
        for (int i = fromIndex; i < toIndex + 1; i++) {
            this.set(i, (E) s[k]);
            k++;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Number[] s = new Number[size];
        s = this.toArray();
        return (E) s[index];
    }

    public Number getMax() {
        long[] m = new long[size];

        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof Number) {
                m[i] = ((Number) array[i]).longValue();
            }
        }
        System.out.println("Max value in collection");
        return (Number) Arrays.stream(m).max().getAsLong();
    }

    public Number getMin() {
        long[] s = new long[size];

        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof Number) {
                s[i] = ((Number) array[i]).longValue();
            }
        }
        System.out.println("Min value in collection");
        return (Number) Arrays.stream(s).min().getAsLong();
    }

    public Number getAverage() {
        double[] s = new double[size];

        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof Number) {
                s[i] = ((Number) array[i]).doubleValue();
            }
        }
        System.out.println(Arrays.toString(s) + " size = " + size());
        System.out.print(" Average: ");
        return (Number) Arrays.stream(s).average().getAsDouble();
    }

    public Number getMedian() {
        double[] s = new double[size];
        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof Number) {
                s[i] = ((Number) array[i]).doubleValue();
            }
        }
        System.out.println(Arrays.toString(s) + " size = " + size());
        Arrays.sort(s);
        System.out.print(" Median: ");
        if (size % 2 != 0)
            return (Number) s[size / 2];
        else {
            return (Number) ((double) (s[(size - 1) / 2] + s[size / 2]) / 2.0);
        }
    }

    public Number[] toArray() {
        Number[] s = new Number[size];
        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof Number) {
                s[i] = (Number) array[i];
            }
        }
        return s;
    }

    public Number[] toArray(int firstIndex, int lastIndex) {
        Number[] s = new Number[lastIndex - firstIndex + 1];
        for (int i = 0; i < s.length; i++) {

            if (array[firstIndex + i] instanceof Number) {
                s[i] = (Number) array[firstIndex + i];
            }
        }
        return s;
    }

    public MatList cut(int firstIndex, int lastIndex) {
        Number[] s = new Number[lastIndex - firstIndex + 1];
        s = this.toArray(firstIndex, lastIndex);
        MatList newMatList = new MatList();
        newMatList.add(s);
        return newMatList;
    }

    public void clear(Number[] numbers) {
        this.removeAll(List.of(numbers));
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
    public boolean contains(final Object o) {
        for (int i = 0; i < size; i++) {
            if (this.array[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        int k = 0;
        for (int i = k; i < size(); i++) {
            if (!c.contains(array[i])) {
                this.remove(array[i]);
                i = i - 1;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < size) return (E[]) Arrays.copyOf(array, size, a.getClass());
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;

    }

    @Override
    public boolean add(E n) {
        resize();
        array[size] = n;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(o)) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean flag = true;
        for (E element : c) {
            flag &= add(element);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        int prevSize = size();
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        Iterator elementsIterator = c.iterator();
        for (int i = index; i < index + c.size(); i++) {
            add(i, (E) elementsIterator.next());
        }
        return size() > prevSize;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = true;
        for (Object obj : c) {
            flag &= remove(obj);
        }
        return flag;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            System.out.println("The index is out of bounds");
            System.exit(-1);
        }
        E oldObject = (E) array[index];
        array[index] = element;
        return oldObject;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index >= this.array.length) {
            System.out.println("The index is out of bounds");
            System.exit(-1);
        }
        resize();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        ++size;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.array.length) {
            System.out.println("The index is out of bounds");
            System.exit(-1);
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        resize();
        return (E) array[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        E[] copy = Arrays.copyOf((E[]) array, size);
        return Arrays.asList(copy).listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            System.out.println("The index is out of bounds");
            System.exit(-1);
        }
        Number[] s = new Number[size];
        s = this.toArray();
        E[] copy = (E[]) Arrays.copyOfRange(s, fromIndex, toIndex + 1);
        return Arrays.asList(copy);
    }

    private void resize() {
        if (size >= array.length) {
            Object[] bigger = new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
    }

    @Override
    public String toString() {
        return "MatList {" +
                Arrays.toString(this.toArray()) +
                "  size =  " + this.size +
                '}';
    }

    private class MyIterator<E> implements Iterator<E> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return this.current < size();
        }

        @Override
        public E next() {
            E value = (E) array[current++];
            return value;
        }
    }
}

