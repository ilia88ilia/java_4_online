package ua.com.illia;

import java.util.*;

public class Dictionary<K, V> {
    private LinkedList<Pair> list = new LinkedList<>();

    int size = 0;

    public Dictionary() {
        super();// а это зачем?)
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public boolean containsKey(K key) {
        boolean containsKey = false;
        for (Pair pair : this.list) {
            if (pair.key.equals(key)) {
                containsKey = true;
                break;
            }
        }
        return containsKey;
    }

    public boolean containsValue(V value) {
        boolean containsValue = false;
        for (Pair pair : this.list) {
            if (pair.value.equals(value)) {
                containsValue = true;
                break;
            }
        }
        return containsValue;
    }

    public V get(K key) {
        V value = null;
        for (Pair pair : this.list) {
            K currentKey = (K) pair.key;
            if (currentKey.equals(key)) {
                value = (V) pair.value;
                break;
            }
        }
        if (value == null) {
            System.out.println("Incorrect Key");
        }
        return value;
    }

    public boolean put(K key, V value) {
        if (!containsKey(key)) {
            Pair pair = new Pair(key, value);
            list.add(pair);
            size++;
        } else {
            for (Pair pair : this.list) {
                if (pair.key.equals(key)) {
                    pair.value = value;
                }
            }
        }
        return true;
    }

    public boolean remove(K key) {
        boolean isKey = false;
        for (Pair pair : this.list) {
            if (pair.key.equals(key)) {
                this.list.remove(pair);
                size--;
                isKey = true;
                break;
            }
        }
        if (!isKey) {
            System.out.println("Incorrect Key");
            return false;
        } else {
            return true;
        }
    }

    public LinkedList<Pair> getList() {
        return list;
    }

    public void setList(LinkedList<Pair> list) {
        this.list = list;
    }

    public boolean putAll(Dictionary<K, V> dictionary) {
        for (Pair pair : dictionary.getList()) {
            K currentKey = (K) pair.key;
            V currentValue = (V) pair.value;
            this.put(currentKey, currentValue);
        }
        return true;
    }

    public boolean clear() {
        Iterator iterator = this.list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        this.size = 0;
        return true;
    }

    public Set<K> keySet() {
        HashSet<K> hashSet = new HashSet<>();
        for (Pair pair : this.list) {
            hashSet.add((K) pair.key);
        }
        return hashSet;
    }

    public Collection<V> values() {
        Collection<V> collection = new ArrayList<>();
        for (Pair pair : this.list) {
            collection.add((V) pair.value);
        }
        return collection;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            Pair pair = list.get(i);
            res += '\n' +
                    " Cars {" +
                    " Number = '" + pair.key + '\'' +
                    " --- Auto = '" + pair.value + '\'' +
                    "} ";
        }
        if(res.equals("")){ res = "{ There is Nothing }";}
        return res;
    }
}


