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

    public void printArrays(){
        /*
        * Arrays는 배열을 다루는데 유용한 메서드가 정의되어 있다.
        */

        int[] arr1 = {1,5,33,52,7};

        //copyOf()는 배열 전체를 복사해서 새로운 배열을 만들어 반환한다. 길이 지정이 가능하다, 기존 배열보다 길면 0으로 채워진다.
        int[] arr2 = Arrays.copyOf(arr1,3);
        int[] arr3 = Arrays.copyOf(arr1,arr1.length);
        int[] arr4 = Arrays.copyOf(arr1,7);
        //copyOfRange 는 시작점을 지정할수있다.
        int[] arr5 = Arrays.copyOfRange(arr1,2,7); //7번째 인덱스는 포함되지 않는다. 즉 2번째 인덱스 부터 6번째 인덱스까지만
        int[] arr6 = Arrays.copyOfRange(arr1,0,7);

        Arrays.sort(arr1);

        System.out.println("arr1 : "+ Arrays.toString(arr1));
        System.out.println("arr1 : "+ Arrays.toString(arr2));
        System.out.println("arr1 : "+ Arrays.toString(arr3));
        System.out.println("arr1 : "+ Arrays.toString(arr4));
        System.out.println("arr1 : "+ Arrays.toString(arr5));
        System.out.println("arr1 : "+ Arrays.toString(arr6));

        //fill(), setAll()
        int[] emptyArr = {3,4,5,6};
        System.out.println("emptyArr: "+ Arrays.toString(emptyArr));

        Arrays.fill(emptyArr,1);//fill() 은 배열의 모든 요소를 지정된된 값으로 채운다.
        System.out.println("filled arr : "+ Arrays.toString(emptyArr));

        Arrays.setAll(arr1, i->(int)(Math.random()*5)+1); // 함수형 인터페이스를 매개변수로 받아 배열을 채운다.

        //Binary Search 해당 key의 index 값을 찾아서 반환한다. *꼭 정렬된 상태여야한다
        int[] arr = {3,10,8,1,5};
        System.out.println("arr : "+Arrays.toString(arr));
        int idx = Arrays.binarySearch(arr,5);
        System.out.println("idx : "+idx);

        Arrays.sort(arr); //정렬 후
        System.out.println("arr : "+Arrays.toString(arr));
        int idx2 = Arrays.binarySearch(arr,5);
        System.out.println("idx : "+idx2);

        //equals(), toString(), deppEquals(), deppToString()
        int[] array = {0,1,2,3,4};
        int[] array2 = {0,1,2,3,4};
        int[][] arr2D={{2,4},{1,6}};
        int[][] arr2D2={{2,4},{1,6}};

        boolean equals = Arrays.equals(array, array2);
        boolean equals2D = Arrays.deepEquals(arr2D,arr2D2);


        if(equals){
            System.out.println( "arr[]1, arr[]2 is equal");
        }
        if(equals2D){
            System.out.println( "arr[][]1, [][]2 is equal");
        }
        System.out.println("arr2D : "+Arrays.deepToString(arr2D));

        //배열을 List로 반환
        Integer[] arr_a = {3,4,5,6};
        List list = Arrays.asList(arr_a);
        System.out.println("list : "+ list);

        List list2 = Arrays.asList(3,4,5,6); // 길이가 정해져서 add 추가 를 할 수 없다.
        list2 = new ArrayList(Arrays.asList(3,4,5,6)); //new Arraylist 에 담아주면 가변길이로 사용할 수 있다.
        list2.add(7);

        System.out.println("list2 : "+list2);
    }

    public void printComparable(){
    //정렬 기준을 제공하는것이 목적, 객체 정렬에 필요한 메서드를 정의한 인터페이스
        //Comparable 기본(default)정렬(sort)기준을 구현하는데 사용
        // compareTo 주어진 객체를 자신과 비교
        //결과가 같으면 0, 오른쪽이 크면 음수 -, 왼쪽이크면 양수 +



        //Comparator 기본 정렬기준 외에 다른 기준으로 정렬하고자 할때 사용
        //Compare 결과가 0이면 같은것, 양수면 왼쪽이 크고, 음수면 오른쪽이 크다

        String[] strArr = {"cat","Dog","lion","tiger"};
        Arrays.sort(strArr);
        System.out.println("strArray : "+strArr);// 대문자,소문자 순 정렬 후 알파벳 순

    }
}
