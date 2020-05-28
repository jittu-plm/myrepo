package com.jiten.samples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Samples {

    public static void main(String[] args) throws IOException {
        intStream();

        System.out.println();
        streamSamples();

        System.out.println();
        System.out.println("add strings and sort..");
        String[] nameArr = new String[]{"Jiten","Sai","Chakram", "Latha", "Prabha", "SKeshav", "Jiten", "Chakram", "Sai"};
            stringSample(nameArr);
    }

    public static void intStream(){
        //print 1 - 10 using IntStream.range
        IntStream
                .range(1,11)
                .forEach(System.out::print);

        System.out.println();
        //skip first five in the range
        IntStream
                .range(1,11)
                .skip(5)
                .forEach(System.out::print);

        System.out.println();

        //range with sum
        System.out.println( "sum = " +
        IntStream
                .range(1,6)
                .sum()
                          );
        System.out.println();

    }


    //stream functions
    public static void streamSamples() throws IOException {

        //using Stream.of
       Stream
               .of("Jiten","Sai","Chakram", "Latha", "Prabha")
               .sorted()
               .findFirst()
               .ifPresent(s -> System.out.println("first = " + s));

        System.out.println();

        //sort String[] using streams
        String[] names = new String[]{"Jiten","Sai","Chakram", "Latha", "Prabha"};
        Arrays.stream(names)
                .sorted((s,s1) -> s.compareTo(s1))
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        //filter names start with S
        String[] nameArr = new String[]{"Jiten","Sai","Chakram", "Latha", "Prabha", "SKeshav"};
        Arrays.stream(nameArr)
                .filter(t -> t.startsWith("S"))
                .sorted((s,s1) -> s.compareTo(s1))
                .forEach(x -> System.out.print(x + " "));
        System.out.println();


        //avg of squares
        int[] nums = new int[] {2,3,4,};
        Arrays.stream(nums)
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
        System.out.println();

        //to lower case
//        String[] nameArr = new String[]{"Jiten","Sai","Chakram", "Latha", "Prabha", "SKeshav"};
        Arrays.stream(nameArr)
                .map(s -> s.toLowerCase())
                .filter(t -> t.startsWith("s"))
                .sorted((s,s1) -> s.compareTo(s1))
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        //read lines from file, and filter them
        Stream<String> lines = Files.lines(Paths.get("sample.txt"));
        lines
                .sorted()
                .filter(x -> x.length() > 3)
                .forEach(x -> System.out.print(x + " "));
        System.out.println();
        lines.close();


        //counting non empty rows in file
        Stream<String> lines1 = Files.lines(Paths.get("sample.txt"));
        int rowCount  = (int) lines1
                .sorted()
                .filter(x -> x.length() > 3)
                .count();
        System.out.println("rowCount = " + rowCount);
        lines.close();

        //find count of doubles
        System.out.println( "Total of doubles = " +
        Stream.of(3.5, 8.9, 10.2, 5.6, 8.9)
                .reduce(0.0, (a,b) -> a + b)
        );

        //find statistics
        System.out.println("Int Statistics = " +
        IntStream.of(10, 8, 22, 7, 34, 5,1)
                .summaryStatistics()
                          );
    }


    /**
     * add, sort, reverse strings
     * @param str
     */
    public static void stringSample(String[] str){
        Set<String> set = new TreeSet<>((s,t) -> {
           return  t.compareTo(s);
        });

        for (int i=0;i<str.length;i++){
            set.add(str[i]);
        }
        set.stream()
                .forEach(s -> System.out.print(s + " "));

       /* Arrays.stream(str).
                filter(s -> set.add(s))
                .forEach(s -> System.out.print(s + " "));
*/
    }
}



