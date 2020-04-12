////1.Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
////2.Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция:
////ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);
////3.Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb). Вводим
////страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль. Контролируем время выполнения:
////программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
////4.Сделать клиен-серверное приложение. Передать по сети сеарилизованный объект.
//
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class Main {
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//        //задание 1
//        System.out.println("    1-е задание.");
//        try(FileInputStream readIn = new FileInputStream("src/Test.txt")){
//            byte[] arr = new byte [256]; // забавно..., разрывает символ, как избавиться? и что именно происходит?
//            //byte[] arr = new byte [3000];
//            int x;
//
//            while ((x = readIn.read(arr))>0){
//                System.out.print(new String(arr, 0, x));
//            }
//            System.out.println();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("    2-е задание.");
//        //задание 2
//
//        ArrayList<InputStream> arrFile = new ArrayList<>();
//        //arrFile.add(new FileInputStream("src/Test.txt"));
//        arrFile.add(new FileInputStream("src/Test1.txt"));
//        arrFile.add(new FileInputStream("src/Test2.txt"));
//        arrFile.add(new FileInputStream("src/Test3.txt"));
//        arrFile.add(new FileInputStream("src/Test4.txt"));
//
//        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(arrFile));
//        int y;
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//
//        while ((y = in.read())!=-1){
//            //System.out.print((char) y);//с кодировкой опять что-то непонятное, и впереди перед "1." добавился кусочек чего-то...
//            baos.write(y); //соберем в поток байты
//        }
//        in.close();
//        System.out.println(baos.toString("utf-8")); //у при выводе правильно укажем кодировку
//
//        File file = new File("src/Test5.txt"); //создадим новый файл
//        file.createNewFile();
//
//        FileWriter fileWriter = new FileWriter("src/Test5.txt", true);//забросим склеенные данные в файл
//        fileWriter.append(baos.toString("utf-8"));
//        fileWriter.close();
//
//        //задание 3
//        System.out.println("    3-е задание.");
//
//
//        //задание 4
//        System.out.println("    4-е задание.");
//        Cat cat1 = new Cat("Tom", 3, "red");
//        //Cat cat2 = new Cat("Boom", 10, "black");
//        System.out.println("Кот до телепортации");
//        Cat.jump(cat1);
//        Cat.voise(cat1);
////        Cat.jump(cat2);
////        Cat.voise(cat2);
//
//        //Телепортируем кота дезинтегрировав и записав в файл, пересылаем по сети в новый файл, и
//        //(можно ли как-то не сливать в файлы посредники?ли можно ли именно файл переслать а не его содержимое?)
//        //потом из файла реинтегрируем его опять в кота ))))
//
//        //разобрали в cat.ser
//        ObjectOutputStream decompCat = new ObjectOutputStream (new FileOutputStream("cat.ser")); //из него восстанавливается нормально
//        decompCat.writeObject(cat1);
//        decompCat.close();
//
//        Thread server = new Thread(new Server());	server.start();//отправляем с клиента на сервер в другой файл cat2.ser
//        Thread client = new Thread(new Client());	client.start();
//
//        //собрали из ПОЛУЧЕННОГО файла cat1.ser (только после записи в файл)
//        ObjectInputStream compCat = new ObjectInputStream (new FileInputStream("cat1.ser")); //в cat 1 приходит искаженныый немного в начале файла?
//        Cat cat = (Cat) compCat.readObject();
//        compCat.close();
//
//        System.out.println("Кот после телепортации");
//        //Нужно провести только после воостановления кота.
//        Cat.jump(cat);//потыкали палкой то что получилось: Жив, Цел? Орел!
//        System.out.print(cat.getName()+" ");
//        System.out.println(cat.getColor()); //и даже того же цвета!!! =()))
//
//    }
//}
