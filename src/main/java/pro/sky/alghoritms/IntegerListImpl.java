package pro.sky.alghoritms;

import pro.sky.alghoritms.exceptions.InvalidIndexException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {


    private Integer[] storage;
    private int size;

    public IntegerListImpl() {
        storage = new Integer[100_000];
    }

    public IntegerListImpl(int size) {
        storage = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
    validateSize();
    validateItem(item);
    storage[size++] = item;
    return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateIndex(index);
        validateSize();
        validateItem(item);
        for (int i = size; i > index; i--) {
            storage[i] = storage[i - 1];
        }
        storage[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateSize();
        validateItem(item);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i], item)) {
                for (int j = i; j < size - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                size--;
                return item;
            }
        }
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        validateSize();
        Integer item = storage[index];
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item, String Inspection_Selection_Bubbles) {
        switch (Inspection_Selection_Bubbles) {
            case "Insertion" -> sortInsertion(storage);
            case "Bubble" -> sortBubble(storage);
            case "Selection" -> sortSelection(storage);
            default -> throw new InvalidIndexException();
        }
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i], item)) {
                return true;
            }
        }
        return false;
    }

    private void sortSelection(Integer[] storage) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (storage[j].compareTo(storage[j + 1]) > 0) {
                    Integer temp = storage[j];
                    storage[j] = storage[j + 1];
                    storage[j + 1] = temp;
                }
            }
        }
    }

    private void sortInsertion(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            Integer key = array[i];
            int j = i;
            while (j > 0 && key.compareTo(array[j - 1]) < 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;
        }

    }

    private void sortBubble(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    Integer temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        for (int i = 0; i < storage.length; i++) {
            validateItem(otherList.get(i));
            }
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
    public Integer[] toArray() {
        return new Integer[0];
    }


    @Override
    public String toString() {
        return "IntegerListImpl{" +
                "storage=" + Arrays.toString(storage) +
                ", size=" + size +
                '}';
    }

    @Override
    public void validateSize() {
        if (size == storage.length) {
            int newSize = storage.length + 5;
            Integer[] newStorage = new Integer[newSize];
            System.arraycopy(storage, 0, newStorage, 0, storage.length);
            storage = newStorage;
        }
    }

    @Override
    public void validateItem(Integer item) {
        if (item == null) {
            throw new InvalidIndexException();
        }
    }

    @Override
    public void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException();
        }

    }

    @Override
    public IntegerList integerListCopy(IntegerList list) {
        IntegerList newIntegerList = new IntegerListImpl(100_001);
        System.arraycopy(this.getStorage(), 0, list.getStorage(), 0, this.getStorage().length);
        list = newIntegerList;
        return list;
    }

    @Override
    public Integer[] getStorage() {
        return storage;
    }
}
