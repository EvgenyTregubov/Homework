package ru.sbt.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CountMapTest {
    public static void main(String[] args) {

        CountMap<Integer> map = new CountMapImpl<Integer>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        int count = map.getCount(5);  // 2
        // int count = map.getCount(6);  // 1
        // int count = map.getCount(10); // 3

        System.out.println(" Количество элементов  " + count);

        System.out.println(" Количество элементов до удаления  " + map.remove(5));
        System.out.println(" Количество элементов  " + map.getCount(5));
        System.out.println(" Количество разных элементов  " + map.size());

    }


    static class CountMapImpl<T> implements CountMap<T> {

        private HashMap<T, Integer> mass;

        CountMapImpl(){
            this.mass = new HashMap<T, Integer>();
        }

        // добавляет элемент в этот контейнер.
        public void add(T o) {
            this.mass.put(o, getCount(o) + 1);
        }

        //Возвращает количество добавлений данного элемента
        public int getCount(T o) {
            int counter = 0; // счетчик
            if(this.mass.get(o) != null)
                return this.mass.get(o);
            else return 0;
        }

        //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
        public int remove(T o) {

            int counter = 0; // счетчик
            if(this.mass.get(o) != null){ // если ключ есть
                counter = getCount(o);
                this.mass.put(o, getCount(o) - 1);

                if(this.mass.get(o) <1){ // удаляем ключ, если нет объектов
                    this.mass.remove(o);
                }
                return counter;
            }
            else{  // если нет ключа
                return 0;
            }
        }

        //количество разных элементов
        public int size() {
            return this.mass.size();
        }

        //Добавить все элементы из source в текущий контейнер,
        // при совпадении ключей,     суммировать значения
        public void addAll(CountMap source) {
            this.mass.putAll( source.toHashMap());
        }

        //Вернуть java.util.Map. ключ - добавленный элемент,
        // значение - количество его добавлений
        public HashMap toHashMap() {
            return this.mass;
        }

        //Тот же самый контракт как и toHashMap(), только всю информацию записать в destination
        public void toHashMap(HashMap destination){
            destination = new HashMap<T,Integer>(this.mass);
        }

    }


    public interface CountMap<T> {
        // добавляет элемент в этот контейнер.
        public void add(T o);

        //Возвращает количество добавлений данного элемента
        public int getCount(T o);

        //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
        public int remove(T o);

        //количество разных элементов
        public int size();

        //Добавить все элементы из source в текущий контейнер,
        // при совпадении ключей,     суммировать значения
        public void addAll(CountMap source);

        //Вернуть java.util.Map. ключ - добавленный элемент,
        // значение - количество его добавлений
        public HashMap toHashMap();

        //Тот же самый контракт как и toHashMap(), только всю информацию записать в destination
        public void toHashMap(HashMap destination);

    }
}