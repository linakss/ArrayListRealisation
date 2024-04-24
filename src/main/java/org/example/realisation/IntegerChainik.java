package org.example.realisation;

import org.example.lists.StringList;

import java.util.Arrays;

public class IntegerChainik implements StringList {
    private int[] array;
    private int sizeArr;

    public void errorSizeOtr(int sizeArr){
        if (sizeArr < 0) throw new IllegalArgumentException("Вместимость не может быть отрицательной, а сейчас она пытается быть таковой :р");
    }
    public void errorItemNull(int item) {
        if (item==null) throw new IllegalArgumentException("Элемент пуст :(");
    }
    public void errorIndexLessThanZero(int index) {
        if (index < 0 || index >= sizeArr) throw new IllegalArgumentException("Индекс меньше 0, это беда :/");
    }
    public void errorsIndexAndItem(int index, int item) {
        if (item==null) throw new IllegalArgumentException("Элемент пуст :(");
        if (index < 0 || index >= sizeArr) throw new IllegalArgumentException("Индекс меньше 0, это беда :/");
    }
    public void listNull(StringList otherList){
        if (otherList == null) throw new IllegalArgumentException("Лист не может быть пустым!");
    }

    public IntegerChainik(int sizeArr) {
        errorSizeOtr(sizeArr);
        this.array = new int[sizeArr];
        this.sizeArr = 0;
    }

    @Override
    public int add(int item){
        errorItemNull(item);
        array[sizeArr] = item;
        sizeArr++;
        return item;
    }

    @Override
    public int add(int index, int item) {
        errorsIndexAndItem(index, item);
        for (int i = sizeArr; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        sizeArr++;
        return item;
    }

    @Override
    public int set(int index, int item) {
        errorsIndexAndItem(index, item);
        int substituteElem = array[index];
        array[index] = item;
        return substituteElem;
    }

    @Override
    public int remove(int item) {
        errorItemNull(item);
        for (int i = 0; i < sizeArr; i++) {
            if (item.equals(array[i])) {
                for (int j = i; j < sizeArr - 1; j++)
                    array[j] = array[j + 1];
            }
            sizeArr--;
        }
        return item;
    }

    @Override
    public int remove(int index) {
        errorIndexLessThanZero(index);
        int removeIndex = array[index];
        for (int i = index; i < sizeArr - 1; i++) {
            array[i] = array[i + 1];
        }
        sizeArr--;
        return removeIndex;
    }

    @Override
    public boolean contains(int item) {
        errorItemNull(item);
        for (int i = 0; i < sizeArr; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int item) {
        errorItemNull(item);
        for (int i = 0; i < sizeArr; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        errorItemNull(item);
        for (int i = sizeArr - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        errorIndexLessThanZero(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        listNull(otherList);
        if (sizeArr != otherList.sizeArr())
            return false;
        for (int i = 0; i < sizeArr; i++) {
            if (!array[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }
    @Override
    public int sizeArr() {
        return sizeArr;
    }

    @Override
    public boolean isEmpty() {
        return sizeArr == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        sizeArr = 0;
    }

    @Override
    public int[] toArray() {
        return Arrays.copyOf(array, sizeArr);
    }

}