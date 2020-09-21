import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Terminal {
    public static void main(String[] args) throws java.io.IOException  {
        System.out.println("Введите пин-код");

        int password = 1234;            // пароль
        int passwordEnterCounter = 3;   // сколько осталось попыток ввести пароль
        boolean passwordIsOk = false;   // введен ли правильный пароль


        while(passwordIsOk == false) {

            // получаем пин-код с клавиватуры посимвольно,  увы придется вводить символы по одному
            Scanner in = new Scanner(System.in);
            ArrayList<Integer> key = new ArrayList<Integer>();

            while (key.size() != 4) {
                try {
                    key.add(in.nextInt());
                } catch (InputMismatchException ex) {
                    System.out.println("Введен не числовой символ.");
                    in.next();
                }
            }

            in.close();


            System.out.println("Введен не числовой символ." + key.toString());
            System.out.println("Введен не числовой символ." + massToCode(key));

            if (password == massToCode(key)) {
                passwordIsOk = true;
                System.out.println("Доступ разрешен.");
            } else {
                System.out.println("Введен не верный пароль.");
                passwordEnterCounter--;
                passwordIsOk = false;

                if(passwordEnterCounter == 0) // запускаем блокировку и таймер на 10 сек
                {
                    passwordEnterCounter = 3; // востанавливаем количество попыток

                }
            }

        }






    }

    private static int massToCode(ArrayList<Integer> mass)
    {
        String srt = mass.get(0).toString() + mass.get(1).toString() + mass.get(2).toString() + mass.get(3).toString();
        srt = srt.substring(0,4);

        int password=1;
        try {
            password = Integer.parseInt(srt);
        }
        catch (NumberFormatException e)
        {
            password = 0;
        }

        return password;

    }

    private void blockTerminal() {
        System.out.println("Попробовать снова можно через");

        Timer timer = new Timer();
        TimerTask task = new MyTask(timer);

        timer.schedule( task,1000);

    }
}

class MyTask extends TimerTask {

    static int counter = 10;
    Timer timer;

    public MyTask(Timer timer) {
        this.timer = timer;
    }

    public void run() {
        System.out.println(counter);
        counter--;

        if(counter == 0)
            timer.cancel();// остановить полет
    }
}