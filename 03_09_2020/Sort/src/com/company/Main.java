package com.company;

public class Main {

    private static int[] mass; // Объявляем массив
    private static int N = 10; // длина массива

    public static void main(String[] args) {

        mass = new int[N]; // Выделение памяти

        for (int i = 0; i < N; i++) // Заполнение массива произвольными значениями
            mass[i] = (int) (1000 * Math.random());


        bubbleSorter(); // сортировка
        printMass();    // вывод на экран

        int find = binFinder(mass[2]);
        if (find !=-1)
            System.out.println(find);




    }

    public static void printMass() { // Вывод на экран всех значений массива
        for (int i = 0; i < N; i++) // Заполнение массива произвольными значениями
            System.out.println( i + ")" + mass[i] );
    }


    public static void bubbleSorter(){     // Метод сортировки пузырьком
        int dummy = 0;
        for (int i = N - 1; i >= 1; i--){
            for (int j = 0; j < i; j++){
                if(mass[j] > mass[j + 1]) { // перестановка элементов

                    dummy = mass[j];      //во временную переменную помещаем первый элемент
                    mass[j] = mass[j+1];       //на место первого ставим второй элемент
                    mass[j+1] = dummy;          //вместо второго элемента пишем первый из временной памяти
                }
            }
        }
    }

    public static int binFinder(int value){ // Метод бинарного поиска

        int start = 0;
        int end = mass.length;

        int medium = (end - start)/2;

        while(end == start) {
            if (mass[medium] > value) {
                end = medium;
            } else {
                start = medium;
            }
        }

        if(mass[medium] == value) {
            System.out.println("Индекс в массиве:" + start);
            return start;
        }
        else{
            System.out.println("Значение не найдено в массиве");
            return -1;
        }
    }

}
