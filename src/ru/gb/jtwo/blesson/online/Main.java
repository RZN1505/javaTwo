package ru.gb.jtwo.blesson.online;

import ru.gb.jtwo.alesson.online.Ball;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private interface MouseListener {
        void mouseDown();
    }

    private static void addMouseListener(MouseListener m) {
        m.mouseDown();
    }

    private static int div(int a, int b) throws ArithmeticException { // 5/5
        return a / b;
    }

    public static boolean test(String testString){
        Pattern p = Pattern.compile("^[0-9]+$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    private static String[][] resultArr (String str) throws CustomExeptionForSymb, CustomExeptionForArrLength {

        String[] strHelp = str.split("\n");
        System.out.println(Arrays.deepToString(strHelp));
        int count = strHelp.length;
        System.out.println(count);
        if (count != 4 ){
            throw new CustomExeptionForArrLength("array length not equals 4, this equal = ", count);
        }
        String[][] strArr = new String[count][count];
        for (int i = 0; i < strArr.length; i++) {
            String [] strOne = strArr[i];
            for (int j = 0; j < strOne.length; j++) {
                String[] strHelpTwo = strHelp[i].split(" ");
                boolean found = test(strHelpTwo[j]);
                if (!found) {
                    throw new CustomExeptionForSymb("string has symbols");
                }
                strOne[j] = strHelpTwo[j];
            }
        }
        return strArr;
    }

    private static int resultOne (String[][] resultArr) {
        int sum = 0;
        for (int i = 0; i < resultArr.length; i++) {
            String [] strOne = resultArr[i];
            for (int j = 0; j < strOne.length; j++) {
                sum = sum + new Integer(strOne[j]);
            }
        };
        return sum/2;
    }

    private static void testMy (String str) {
        try  {
        String [][] helpVarArr  = resultArr(str);
        System.out.println(Arrays.deepToString(helpVarArr));
        int resultOneH = resultOne(helpVarArr);
        System.out.println(resultOneH);
        } catch (CustomExeptionForSymb ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (CustomExeptionForArrLength ex) {
            System.out.print(ex.getMessage());
            System.out.println(ex.getLength());
            ex.printStackTrace();
        }
    }

    private static class IOStream implements Closeable {
        IOStream() throws IOException {
//            throw new IOException("construction failed");
            System.out.println("constructed");
        }
        public void open() throws FileNotFoundException {
            throw new FileNotFoundException("flash drive not found!");
//            System.out.println("open");
        }

        public void doIOthings() throws SQLException {
            throw new SQLException("cannot do io things");
            //System.out.println("do IO things");
        }

        @Override
        public void close() {
            throw new NullPointerException("nothing to close");
//            System.out.println("close");
        }
    }


    public static void main(String[] args) {

       /* try (IOStream ioStream = new IOStream()) {
            ioStream.open();
            ioStream.doIOthings();
        } catch (FileNotFoundException canvas) {
            throw new RuntimeException(canvas);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }*/

       testMy("7 5 6 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0\n300 3 1 0");
       testMy("7gg 5 6 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0");
        testMy("7 5 6 3\n2 3 2 2\n5 6 7 1\n300 3 1 0");


//        System.out.println(div(1, 5));
//        System.out.println(div(5, 0));
    }

    private static void anonymousExample() {
        class MouseAdapter implements MouseListener {
            @Override
            public void mouseDown() {

            }
        }
        MouseAdapter h = new MouseAdapter();
        addMouseListener(h);
        addMouseListener(new MouseAdapter());
        addMouseListener(new MouseListener() {
            @Override
            public void mouseDown() {

            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown() {

            }
        });
        addMouseListener(() -> {

        });
    }

    private static void interfaceExamples() {
        Cat c = new Cat();
        c.breathe();

        Animal a = new Cat();
        a.breathe();

        Minotaur m = new Minotaur();
        m.walk();
        m.voice();
        Human[] city = {m, new Man()};
        for (int i = 0; i < city.length; i++) {
            city[i].walk();
        }
        Human h = m;
        h.walk();
//        h.voice();
        Bull b = m;
        b.walk();
        b.voice();
        Animal z = m;
        z.breathe();
    }
}
