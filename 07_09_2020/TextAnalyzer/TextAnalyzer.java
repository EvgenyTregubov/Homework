import java.util.ArrayList;

class TextAnalyzer {
    public static void main(String[] args) {

        ArrayList<String> file = new ArrayList<String>();
        file.add("Каждый");
        file.add("охотник");
        file.add("желает");
        file.add("знать");
        file.add("где");
        file.add("сидит");
        file.add("фазан");
        file.add("где");
        file.add("где");
        file.add("где");
        file.add("где");



        // Задание 1: Подсчитайте количество различных слов в файле.
        int counter = 0; // счетчик
        for(int i = 0; i < file.size(); i++){
            int current_counter = 0;

            for(int j = 0; j < file.size(); j++){
                if(file.get(i).equals(file.get(j)))
                    current_counter++;
            }
            if(current_counter > 1)
                counter++;
        }


        System.out.print("Количество различных слов в файле: " + counter);







    }