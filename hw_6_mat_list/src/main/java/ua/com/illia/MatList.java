package ua.com.illia;

import java.util.*;
import java.util.function.Consumer;

public class MatList<T extends Number> implements List<T> {

    private static final int SIZE = 10;
    public Number[] array;
    int size;

    public MatList() {
        array = new Number[SIZE];
    }

    public MatList(T[]... numbers) {
        for (T[] number : numbers)
            this.array = number;
    }

    public MatList(T... numbers) {
        array = numbers;
        size = numbers.length;
    }


    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        add((T) null);
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
    }

    @Override
    public boolean add(T e) {
        if (size == array.length) {
            Number[] newArray = new Number[(int) (size * 1.5)];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = e;
        size++;
        return true;
    }

    public void add(T... e) {
        for (T newArray : e) {
            add(newArray);
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (Object number : c.toArray()) {
            add((T) number);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c == null)
            throw new NoSuchElementException();
        if (index < 0 && index >= size) return false;
        Object[] numbers = c.toArray();
        for (int i = index; i < numbers.length; i++) {
            add((T) numbers[i]);
        }
        return true;
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
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < size)
            return (E[]) Arrays.copyOf(array, size, a.getClass());
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object v : c.toArray())
            if (!contains(v))
                return false;
        return true;
    }

    @Override
    public T get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        T value = (T) array[index];
        array[index] = element;
        return value;
    }

    @Override
    public int indexOf(Object o) {
        Object[] objectIndex = array;
        for (int i = 0; i < size; i++) {
            if (objectIndex[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Object[] arrayIndex = array;
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (arrayIndex[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(arrayIndex[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        Object[] list = Arrays.copyOfRange(array, fromIndex, toIndex);
        MatList newArray = new MatList();
        for (int i = 0; i < list.length; i++) {
            newArray.add((Number) list[i]);
        }
        return newArray;
    }

    public void join(MatList... ml) {
        for (MatList joinList : ml) {
            Object[] list = joinList.toArray();
            for (int i = 0; i < list.length; i++) {
                add((T) list[i]);
            }
        }
    }

    public void intersection(MatList... ml) {
        for (MatList joinList : ml) {
            Object[] list = array;
            for (int i = 0; i < list.length; i++) {
                if (!joinList.contains(list[i])) {
                    list[i] = null;
                }
            }
            clear();
            for (int i = 0; i < list.length; i++) {
                if (list[i] != null) {
                    add((T) list[i]);
                }
            }
        }
    }

    @Override
    public boolean remove(Object o) {
        Object[] list = array;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(o)) {
                list[i] = null;
                if ((size - 1) > i)
                    System.arraycopy(list, i + 1, list, i, (size - 1) - i);
                list[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        Object[] list = array;
        T e = (T) array[index];
        if ((size - 1) > index)
            System.arraycopy(list, index + 1, list, index, (size - 1) - index);
        list[size - 1] = null;
        size--;
        return e;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] list = c.toArray();
        Number[] number = this.array;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < number.length; j++)
                if (list[i].equals(number[j])) {
                    remove(number[j]);
                }
            this.array = number;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Number[] number = new Number[c.size() - 1];
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (c.contains(array[i])) {
                number[k] = array[i];
                k++;
                size--;
            }
        }
        array = number;
        return true;
    }

    @Override
    public void clear() {
        array = array;
        size = 0;
    }

    public void sortDesc() {
        Object[] list = this.toArray();
        Collections.sort(Arrays.asList(list), Collections.reverseOrder());
        this.array = (Number[]) Arrays.copyOf(list, size);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        boolean sort;
        do {
            sort = false;
            for (int i = firstIndex; i < lastIndex - 1; i++) {
                if (array[i].intValue() < array[i + 1].intValue()) {
                    Number temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sort = true;
                }
            }
        } while (sort);
    }

    public void sortDesc(T number) {
        if (indexOf(number) != -1)
            sortDesc(indexOf(number), size);
    }

    public void sortAsc() {
        Object[] s = this.toArray();
        Arrays.sort(s);
        this.array = (Number[]) Arrays.copyOf(s, size);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        Object[] sortArray = this.toArray(firstIndex, lastIndex);
        Arrays.sort(sortArray);
        int k = 0;
        for (int i = firstIndex; i < lastIndex + 1; i++) {
            this.set(i, (T) sortArray[k]);
            k++;
        }
    }

    public void sortAsc(T value) {
        int fromIndex = this.indexOf(value);
        int toIndex = this.size() - 1;
        this.sortAsc(fromIndex, toIndex);
    }

    public Number getMax() {
        sortDesc();
        return get(0);
    }

    public Number getMin() {
        sortAsc();
        return get(0);
    }

    public double getAverage() {
        double number = 0.0;
        for (int i = 0; i < size; i++) {
            number += get(i).doubleValue();
        }
        return number / size;
    }

    public Number getMedian() {
        sortAsc();
        return get(size / 2);
    }

    public Object[] toArray(int firstIndex, int lastIndex) {
        Object[] list = new Object[lastIndex - firstIndex + 1];
        for (int i = 0; i < list.length; i++) {
            if (array[firstIndex + i] instanceof Number) {
                list[i] = array[firstIndex + i];
            }
        }
        return list;
    }

    public MatList cut(int firstIndex, int lastIndex) {
        Object[] list = Arrays.copyOfRange(array, firstIndex, lastIndex);
        MatList newList = new MatList();
        for (int i = 0; i < list.length; i++) {
            newList.add((Number) list[i]);
        }
        return newList;
    }

    public void clear(Number[] number) {
        removeAll(Arrays.stream(number).toList());
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        T[] copy = Arrays.copyOf((T[]) array, size);
        return Arrays.asList(copy).listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public class Iterator implements java.util.Iterator<T> {
        int index;
        int lastIndex;

        Iterator() {
        }

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public T next() {
            int i = index;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] list = MatList.this.array;
            if (i >= list.length)
                throw new ConcurrentModificationException();
            index = i + 1;
            return (T) list[lastIndex = i];
        }

        @Override
        public void remove() {
            if (lastIndex < 0)
                throw new IllegalStateException();
            try {
                MatList.this.remove(lastIndex);
                index = lastIndex;
                lastIndex = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Objects.requireNonNull(action);
            final int size = MatList.this.size;
            int i = index;
            if (i < size) {
                final T[] es = (T[]) array;
                for (; i < size; i++)
                    action.accept(es[i]);
                index = i;
                lastIndex = i - 1;
            }
        }
    }

    @Override
    public String toString() {
        return "Result { " +
                Arrays.toString(this.toArray()) +
                " }";
    }

}
