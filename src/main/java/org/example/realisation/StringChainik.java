package org.example.realisation;

import org.example.lists.StringList;

import java.util.Arrays;

public class StringChainik implements StringList {
    private String[] array;
    private int sizeArr;
    
    public void errorSizeOtr(int sizeArr){
        if (sizeArr < 0) throw new IllegalArgumentException("Вместимость не может быть отрицательной, а сейчас она пытается быть таковой :р");
    }
    public void errorItemNull(String item) {
        if (item==null) throw new IllegalArgumentException("Элемент пуст :(");
    }
    public void errorIndexLessThanZero(int index) {
        if (index < 0 || index >= sizeArr) throw new IllegalArgumentException("Индекс меньше 0, это беда :/");
    }
    public void errorsIndexAndItem(int index, String item) {
        if (item==null) throw new IllegalArgumentException("Элемент пуст :(");
        if (index < 0 || index >= sizeArr) throw new IllegalArgumentException("Индекс меньше 0, это беда :/");
    }
    public void listNull(StringList otherList){
        if (otherList == null) throw new IllegalArgumentException("Лист не может быть пустым!");
    }

    public StringChainik(int sizeArr) {
        errorSizeOtr(sizeArr);
        this.array = new String[sizeArr];
        this.sizeArr = 0;
    }

    @Override
    public String add(String item){
        errorItemNull(item);
        array[sizeArr] = item;
        sizeArr++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        errorsIndexAndItem(index, item);
        for (int i = sizeArr; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        sizeArr++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        errorsIndexAndItem(index, item);
        String substituteElem = array[index];
        array[index] = item;
        return substituteElem;
    }

    @Override
    public String remove(String item) {
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
    public String remove(int index) {
        errorIndexLessThanZero(index);
        String removeIndex = array[index];
        for (int i = index; i < sizeArr - 1; i++) {
            array[i] = array[i + 1];
        }
        sizeArr--;
        return removeIndex;
    }

    @Override
    public boolean contains(String item) {
        errorItemNull(item);
        for (int i = 0; i < sizeArr; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        errorItemNull(item);
        for (int i = 0; i < sizeArr; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        errorItemNull(item);
        for (int i = sizeArr - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
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
    public String[] toArray() {
        return Arrays.copyOf(array, sizeArr);
    }

}