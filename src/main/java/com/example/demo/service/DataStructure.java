package com.example.demo.service;

import java.util.*;
import java.util.stream.Stream;

public class DataStructure {

    public void printList() {
        System.out.println("================== List ======================");
        System.out.println();
        int[] array = {4, 10, 55, 6, 2, 4};
        System.out.println("1. original array : " + Arrays.toString(array));

        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int k = i + 1; k < array.length; k++) {
                if (array[i] > array[k]) {
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
        }
        System.out.println("array after for : " + Arrays.toString(array));
        System.out.println();

        array = new int[]{4, 10, 55, 6, 2, 4};
        System.out.println("2. original array : " + Arrays.toString(array));
//        for (int i : array) {
//            System.out.println("arr element : "+i);
//        }
        Arrays.sort(array);
        System.out.println("Arrays.sort(array) sorted finish!!");
        System.out.println("sorted array : " + Arrays.toString(array));

    }

    public void printLinkedList() {
        System.out.println("================== linked list ======================");
        System.out.println();
        LinkedList<String> strList = new LinkedList<>();
        strList.add("hi");
        strList.add("hello");
        strList.addLast("last");
        strList.addFirst("first");
        strList.add("apple");
        strList.add("zip");
        strList.add("middle");


        //for문 변경 과정
//        for(int x =0; x<strList.size(); x++){//인덱스 번호가 필요할 경우 쓰자
//            System.out.println("elem"+(x+1)+" : "+strList.get(x));
//        }

//        for (String x : strList) { 
//            System.out.println("Linked list element >> " + x);
//        }

        strList.forEach(x -> System.out.println("Linked List element : " + x)); //람다식
//        strList.forEach(System.out::println); //메소드참조

        System.out.println("Linked list >>" + strList);
//        strList.sort(String::compareTo);
        Collections.sort(strList);
        System.out.println("Collections.sort(strList) Sorted Linked list >>" + strList);


    }

    public void printArrayList() {
        System.out.println("================== Array list ======================");
        System.out.println();
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(5, 30, 3, 2, 7, 7));
        intList.add(12);
        intList.forEach(x -> System.out.println("Array List element : " + x));
        System.out.println("Arraylist >>" + intList);
//        intList.sort(Integer::compareTo);
        Collections.sort(intList);
        System.out.println("Collections.sort(intList) Sorted Arraylist >>" + intList);


    }

    public void printTreeSet() {
        System.out.println("================== Tree Set======================");
        System.out.println();
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(7);
        treeSet.add(52);
        treeSet.add(12);
        treeSet.add(1);
        treeSet.add(72);

        System.out.println("treeSet >> " + treeSet);


    }

    public void printQueueStackBasic() {
        System.out.println("================== Queue, Stack ======================");
        System.out.println();

        Queue<String> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        q.offer("처음");
        q.offer("둘");
        q.offer("셋");
        q.offer("넷");
        q.offer("다섯");

        stack.push(1);
        stack.push(20);
        stack.push(55);
        stack.push(87);
        stack.push(9);
        while (!q.isEmpty()) {
            System.out.println("queue polling : " + q.poll());
        }
        while (!stack.isEmpty()) {
            System.out.println("stack pop : " + stack.pop());
        }

    }

    public void printStack(String expression) {
        System.out.println("================== Queue, Stack ======================");
        System.out.println();
        System.out.println("expression length : " + expression.length());
        System.out.println("expression expression : " + expression);
        Stack<String> st = new Stack<>();
        try {
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == '(') {
                    st.push(ch + "");
                } else if (ch == ')') {
                    st.pop();
                }
            }
            if (st.isEmpty()) {
                System.out.println("Stack이 비었습니다. 괄호가 일치!");
            } else {
                System.out.println("stack's peek : " + st.peek());
                System.out.println("Stack에 남아있습니다. 괄호 불일치!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception!! 괄호가 일치하지 않습니다");
        }

    }

    static Queue<String> qu = new LinkedList<>();
    static final int MAX_SIZE = 5; //맥스 사이즈, 최근 5개 목록만 나오게

    public void printQueue() {
//        Queue는 인터페이스, 인터페이스를 구현한 구현체는 대표적으로 링크드리스트

        System.out.println("help를 입력하시면 도움말을 볼 수 있습니다.");

        while (true) {
            System.out.println(">>");

            try {
                //화면으로 부터 라인단위로 입력 받는다.
                Scanner scan = new Scanner(System.in);
                String input = scan.nextLine().trim();

                if ("".equals(input)) continue;
                if (input.equalsIgnoreCase("q")) {
                    System.exit(0);//프로그램 종료
                } else if (input.equalsIgnoreCase("help")) {
                    System.out.println(" help - 도움말을 보여줍니다. ");
                    System.out.println(" Q (q) - 프로그램을 종료합니다. ");
                    System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");

                } else if (input.equalsIgnoreCase("history")) {
//                    save(input); //입력받은 명령어를 저장하고
                    //링크드 리스트의 내용을 보여준다.
                    LinkedList list = (LinkedList) qu;
                    for (int i = 0; i < list.size(); i++)
                        System.out.println((i + 1) + "." + list.get(i));

                } else {
                    save(input);
                    System.out.println("input : " + input);
                }

            } catch (Exception e) {
                System.out.println("입력오류 입니다");
            }
        }

    }

    private void save(String input) {
        //Queue에 저장한다.
        if (!"".equals(input)) {//빈문자열을 입력한게 아니라면
            qu.offer(input);
        }
        if (qu.size() > MAX_SIZE)
            qu.remove();
    }

    public void printIterator(){
        Collection<Integer> collection = new TreeSet<>();
        collection.add(0);
        collection.add(3);
        collection.add(45);
        collection.add(61);
        collection.add(15);

        Iterator<Integer> it = collection.iterator();

        while (it.hasNext()){
            Object obj = it.next();
            System.out.println("list element : "+obj);
        }

        //위에서 다 읽었기때문에 다시 얻어와야 한다.
        it = collection.iterator();

        while (it.hasNext()){
            Object obj = it.next();
            System.out.println("list element : "+obj);
        }

        //for문으로도 할 수 있지만, 위의 List를 Set으로 바꾸게 되면 get 함수를 쓸 수 없다. 따라서 Iterator를 사용하면 위에만 바꿔주면 되고 , 사용하기 편하다.
//        for(int i=0; i<collection.size(); i++){
//            Object obj = collection.get(i);
//            System.out.println("list element : "+obj);
//        }
    }
}
