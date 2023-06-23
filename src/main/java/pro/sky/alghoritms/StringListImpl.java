package pro.sky.alghoritms;

import pro.sky.alghoritms.exceptions.InvalidIndexException;
import pro.sky.alghoritms.exceptions.NullItemException;
import pro.sky.alghoritms.exceptions.StorageIsFullException;

import java.util.Arrays;

public class StringListImpl implements StringList {


    private final String[] storage;
    private int size;

    public StringListImpl() {
        storage = new String[10];
    }

    public StringListImpl(int size) {
        storage = new String[size];
    }


    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;
    }


    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
        for (int i = size; i > index; i--) {
            storage[i] = storage[i - 1];
        }
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateItem(item);
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new NullItemException();
        }
        if (index != size - 1) {
            for (int i = index; i < size - 1; i++) {
                storage[i] = storage[i + 1];
            }
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
        if (index != size - 1) {
            for (int i = index; i < size - 1; i++) {
                storage[i] = storage[i + 1];
            }
        }
        size--;
        return null;
    }

    @Override
    public boolean contains(String item) {
        for (String s : storage) {
            if (s.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        validateItem(otherList.toString());
        return Arrays.equals(this.toArray(), otherList.toArray());
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
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateItem (String item){
        if(item == null){
            throw new NullItemException();
        }
    }

    private void validateSize(){
        if(size == storage.length){
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index){
        if(index < 0 || index > storage.length){
            throw new InvalidIndexException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (String el : storage) {
            if (el != null) {
                sb.append(el + " ");
            }
        }
        return sb.toString();
    }

}
