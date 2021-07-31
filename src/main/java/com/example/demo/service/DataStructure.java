package com.example.demo.service;

import java.util.*;

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

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,6,7,8,9));
        System.out.println("numbers : "+numbers.toString());
        numbers.removeIf(n -> (n%3==0)); //람다식 필터링, 3의 배수이면 삭제
        System.out.println("numbers filtered: "+numbers.toString());

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

    public void printHashSet() {
        System.out.println("================== Hash Set======================");
        /*
         *  Set Interface 구현, 순서유지x, 중복허용x
         *  set 이 필요할 경우 HashSet을 일반적으로 쓴다.
         *  순서를 유지하고 싶으면 LinkedHashSet 클래스를 사용하면 된다
         */
        System.out.println();

        //-------------예제 1 --------------------------
//        Set<Integer> linkedSet = new LinkedHashSet<>();
        Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"}; //중복을 제거
        Set set = new HashSet();
        for (Object obj : objArr) {
            set.add(obj);
        }
        //HashSet에 저장된 요소들을 출력한다.
        System.out.println("set : " + set);

        Iterator iterator = set.iterator();

        //HashSet에 저장된 요소들을 출력한다. ( Iterator 이용 )
        while (iterator.hasNext()) {
            System.out.println("iterator :" + iterator.next());
        }//결과는 11234 이고, 저장순서를 저장하지 않기 때문에 1과 1 중에 어떤것이 문자열이고 정수 1인지 모른다


        //---------------------예제 2 ---------------------
        Set hashSet2 = new HashSet();
        Random random = new Random();
        int lottoNum;
        //set의 크기가 6보다 작은 동안 1~45 사이의 난수를 저장
        for (int i = 0; hashSet2.size() < 6; i++) {
            lottoNum = random.nextInt(45) + 1;
            hashSet2.add(lottoNum);
        }
        iterator = hashSet2.iterator();
        System.out.println("random num set :" + hashSet2);
        while (iterator.hasNext()) {
            System.out.println("rand iter : " + iterator.next());
        }
        //list에 담아서 정렬
        List list = new LinkedList(hashSet2);
        System.out.println("list : " + list);
        Collections.sort(list); //정렬이기때문에 set은 sort의 매개변수로 올 수 없다. set을 list로 옮기고 정렬
        System.out.println("sorted list : " + list);

        //------------------예제 3----------------------
        //HashSet은 객체를 저장하기 전에 기존에 같은 객체가 있는지 확인한다. 있으면 저장x
        // boolean add(Object o) 는 저장할 객체의 equals() 와 hashCode()를 호출
        // HashSet이 정상작동(중복을 확인)하려면 equals()와 hashCode()가 오버라이딩 되어 있어야 함
        // 클래스를 작성할때 자동완성에서 equals() 와 HashCode() 를 같이 generate 해주면 된다.

        HashSet set3 = new HashSet();

        set.add("abc");
        set.add("abc"); //중복은 저장안됨
        set.add(new Person("David", 10));
        set.add(new Person("David", 10));

        System.out.println("set : " + set);

        //교집합 차집합 합집합
        HashSet setA = new HashSet();
        HashSet setB = new HashSet();
        HashSet setHab = new HashSet();
        HashSet setKyo = new HashSet();
        HashSet setCha = new HashSet();

        setA.add("1");
        setA.add("2");
        setA.add("3");
        setA.add("4");
        setA.add("5");
        System.out.println("set A : " + setA);

        setB.add("4");
        setB.add("5");
        setB.add("6");
        setB.add("7");
        setB.add("8");
        System.out.println("set B : " + setB);

        Iterator iter = setB.iterator();
        while (iter.hasNext()) {//교집합
            Object tmp = iter.next();
            if (setA.contains(tmp))
                setKyo.add(tmp);
        }

        iter = setA.iterator();
        while (iter.hasNext()) {//차집합
            Object tmp = iter.next();
            if (!setB.contains(tmp))
                setCha.add(tmp);
        }

        iter = setA.iterator();
        while (iter.hasNext())
            setHab.add(iter.next());

        iter = setB.iterator();
        while (iter.hasNext())
            setHab.add(iter.next());

        System.out.println("A 교집합 B = " + setKyo);
        System.out.println("A 합집합 B = " + setHab);

    }


    public class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Person person = (Person) o;
//            return age == person.age && Objects.equals(name, person.name);
            if (!(o instanceof Person)) return false;

            Person p = (Person) o;
            //나 자신의 이름과 나이를 p와 비교
            return this.name.equals(p.name) && this.age == p.age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    public void printTreeSet() {
        System.out.println("================== Tree Set======================");
        /*
         *  Set Interface 구현, 순서유지x, 중복허용x
         *  범위검색과 정렬에 유리한 컬렉션 클래스
         *  HashSet보다 데이터 추가,삭제에 시간이 더 걸림
         */
        System.out.println();
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(7);
        treeSet.add(52);
        treeSet.add(12);
        treeSet.add(1);
        treeSet.add(72);

        //first() 정렬된 순서에서 첫번째 객체를 반환한다.
        //last() 마지막 객체 반환
        //ceiling() 지정된 객체와 같은 객체를 반환, 없으면 큰 값중 가장 가까운값의 객체 반환, 그것도 없으면 null
        //floor() 지정된 객체와 같은 객체를 반환, 없으면 큰 값중 가장 가까운값의 객체 반환, 그것도 없으면 null
        System.out.println("treeSet >> " + treeSet);
        System.out.println("treeSet.ceiling input 7>> " + treeSet.ceiling(7));
        System.out.println("treeSet.ceiling input 8>> " + treeSet.ceiling(8));
        System.out.println("treeSet.floor 52>> " + treeSet.floor(52));
        System.out.println("treeSet.floor 50>> " + treeSet.floor(50));
        //higher() 지정된 객체보다 큰 객체 반환,없으면 null
        System.out.println("treeSet.higher 52>> " + treeSet.higher(52));
        System.out.println("treeSet.higher 72>> " + treeSet.higher(72));
        //lower() 지정된 객체보다 작은 객체 반환,없으면 null
        System.out.println("treeSet.lower 2>> " + treeSet.lower(2));
        System.out.println("treeSet.lower 1>> " + treeSet.lower(1));

        //subSet(from, to) 범위검색의 결과 반환한다. to는 범위에 포함되지 않음 ( from 이상 to 미만 )
        System.out.println("treeSet.subSet 1,52>> " + treeSet.subSet(1, 52));
        System.out.println("treeSet.subSet 1,52>> " + treeSet.subSet(1, 53));
        //headSet() 지정된 객체 to elem 보다 작은값의 객체들을 반환
        System.out.println("treeSet.headSet 52>> " + treeSet.headSet(52));
        System.out.println("treeSet.headSet 1>> " + treeSet.headSet(1));
        //tailSet() 지정된 객체 from elem 보다 같거나 큰 객체들을 반환
        System.out.println("treeSet.tailSet 7>> " + treeSet.tailSet(7));
        System.out.println("treeSet.tailSet 72>> " + treeSet.tailSet(72));

        //이진탐색트리(Binary search tree)로 구현.범위탐색과 정렬에 유리
        //이진트리는 모든 노드가 최대 2개의 하위 노드를 갖음
        //각 요소(node)가 나무(tree)형태로 연결(linked list의 변형)
        //이진 탐색 트리 - 부모보다 작은 값은 왼쪽 큰 값은 오른쪽에 저장
        //데이터가 많아질수록 추가, 삭제에 시간이 더 걸림(비교 횟수가 증가하기 때문)
        Set set = new TreeSet(new TestComp()); // 범위검색, 정렬. 정렬안해도 됨. HashSet은 Linked list에 담은 후 sort

        //Set은 중복을 허용하지 않기때문에 add메서드 실행시 equals 와 hashCode를 호출해서 비교, 같은게 있으면 false 반환
        //HashSet은 equals(),hashCode()를 이용해 비교하고, TreeSet은 Compare()을 호출해서 비교한다.
//        for(int i =0; set.size() <6; i++){
//            int num = (int)(Math.random()*45)+1;
        set.add(new TreeSetTest()); //형변환 예외 발생 !! 비교하면서 저장해야하는데 비교기준이 없기때문.
        set.add(new TreeSetTest()); //형변환 예외 발생 !! 비교하면서 저장해야하는데 비교기준이 없기때문.
        set.add(new TreeSetTest()); //형변환 예외 발생 !! 비교하면서 저장해야하는데 비교기준이 없기때문.
        set.add(new TreeSetTest()); //형변환 예외 발생 !! 비교하면서 저장해야하는데 비교기준이 없기때문.
//        }
        System.out.println(set);


        TreeSet stringSet = new TreeSet();

        String from = "b";
        String to = "d";

        stringSet.add("abc");
        stringSet.add("alien");
        stringSet.add("bat");
        stringSet.add("car");
        stringSet.add("Car");
        stringSet.add("disc");
        stringSet.add("dance");
        stringSet.add("dZZZZ");
        stringSet.add("dZZZZ");
        stringSet.add("elephant");
        stringSet.add("elevator");
        stringSet.add("fan");
        stringSet.add("flower");

        System.out.println(stringSet);
        System.out.println("range search : from" + from + "to" + to);
//        System.out.println("result 1 : "+stringSet.subSet(from,to));
//        System.out.println("result 2 : "+stringSet.subSet(from,to+"zzz"));
        System.out.println("result 1 : " + stringSet.subSet("b", "e"));
        System.out.println("result 1 : " + stringSet.subSet(from, "dZZZZ"));


        TreeSet set3 = new TreeSet();
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

        for (int i = 0; i < score.length; i++) {
            set3.add(score[i]);
        }
        System.out.println("50보다 작은 값 : " + set3.headSet(50));
        System.out.println("50보다 큰 값 : " + set3.tailSet(50));
        System.out.println("40과 80 사이의 값 : " + set3.subSet(40, 80));
        //subset 범위검색의 결과를 반환한다
        //headset 지정된 객체보다 작은 값의 객체들을 반환한다
        //tailset지정된 객체보다 큰 값의 객체들을 반환한다
        //트리 순회
        // 이진 트리의 모든 노드를 한번씩 읽는 것을 트리 순회라고 한다.
    }

    class TreeSetTest {
    }

    class TestComp implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
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

    public void printIterator() {
        Collection<Integer> collection = new TreeSet<>();
        collection.add(0);
        collection.add(3);
        collection.add(45);
        collection.add(61);
        collection.add(15);

        Iterator<Integer> it = collection.iterator();

        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println("list element : " + obj);
        }

        //위에서 다 읽었기때문에 다시 얻어와야 한다.
        it = collection.iterator();

        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println("list element : " + obj);
        }
        //for문으로도 할 수 있지만, 위의 List를 Set으로 바꾸게 되면 get 함수를 쓸 수 없다. 따라서 Iterator를 사용하면 위에만 바꿔주면 되고 , 사용하기 편하다.
//        for(int i=0; i<collection.size(); i++){
//            Object obj = collection.get(i);
//            System.out.println("list element : "+obj);
//        }
    }

    public void printArrays() {
        /*
         * Arrays는 배열을 다루는데 유용한 메서드가 정의되어 있다.
         */

        int[] arr1 = {1, 5, 33, 52, 7};

        //copyOf()는 배열 전체를 복사해서 새로운 배열을 만들어 반환한다. 길이 지정이 가능하다, 기존 배열보다 길면 0으로 채워진다.
        int[] arr2 = Arrays.copyOf(arr1, 3);
        int[] arr3 = Arrays.copyOf(arr1, arr1.length);
        int[] arr4 = Arrays.copyOf(arr1, 7);
        //copyOfRange 는 시작점을 지정할수있다.
        int[] arr5 = Arrays.copyOfRange(arr1, 2, 7); //7번째 인덱스는 포함되지 않는다. 즉 2번째 인덱스 부터 6번째 인덱스까지만
        int[] arr6 = Arrays.copyOfRange(arr1, 0, 7);

        Arrays.sort(arr1);

        System.out.println("arr1 : " + Arrays.toString(arr1));
        System.out.println("arr1 : " + Arrays.toString(arr2));
        System.out.println("arr1 : " + Arrays.toString(arr3));
        System.out.println("arr1 : " + Arrays.toString(arr4));
        System.out.println("arr1 : " + Arrays.toString(arr5));
        System.out.println("arr1 : " + Arrays.toString(arr6));

        //fill(), setAll()
        int[] emptyArr = {3, 4, 5, 6};
        System.out.println("emptyArr: " + Arrays.toString(emptyArr));

        Arrays.fill(emptyArr, 1);//fill() 은 배열의 모든 요소를 지정된된 값으로 채운다.
        System.out.println("filled arr : " + Arrays.toString(emptyArr));

        Arrays.setAll(arr1, i -> (int) (Math.random() * 5) + 1); // 함수형 인터페이스를 매개변수로 받아 배열을 채운다.

        //Binary Search 해당 key의 index 값을 찾아서 반환한다. *꼭 정렬된 상태여야한다
        int[] arr = {3, 10, 8, 1, 5};
        System.out.println("arr : " + Arrays.toString(arr));
        int idx = Arrays.binarySearch(arr, 5);
        System.out.println("idx : " + idx);

        Arrays.sort(arr); //정렬 후
        System.out.println("arr : " + Arrays.toString(arr));
        int idx2 = Arrays.binarySearch(arr, 5);
        System.out.println("idx : " + idx2);

        //equals(), toString(), deppEquals(), deppToString()
        int[] array = {0, 1, 2, 3, 4};
        int[] array2 = {0, 1, 2, 3, 4};
        int[][] arr2D = {{2, 4}, {1, 6}};
        int[][] arr2D2 = {{2, 4}, {1, 6}};

        boolean equals = Arrays.equals(array, array2);
        boolean equals2D = Arrays.deepEquals(arr2D, arr2D2);


        if (equals) {
            System.out.println("arr[]1, arr[]2 is equal");
        }
        if (equals2D) {
            System.out.println("arr[][]1, [][]2 is equal");
        }
        System.out.println("arr2D : " + Arrays.deepToString(arr2D));

        //배열을 List로 반환
        Integer[] arr_a = {3, 4, 5, 6};
        List list = Arrays.asList(arr_a);
        System.out.println("list : " + list);

        List list2 = Arrays.asList(3, 4, 5, 6); // 길이가 정해져서 add 추가 를 할 수 없다.
        list2 = new ArrayList(Arrays.asList(3, 4, 5, 6)); //new Arraylist 에 담아주면 가변길이로 사용할 수 있다.
        list2.add(7);

        System.out.println("list2 : " + list2);
    }

    public void printComparable() {
        //'정렬 기준'을 제공하는것이 목적, '객체' 정렬에 필요한 메서드를 정의한 인터페이스
        //Comparable 기본(default)정렬(sort)기준을 구현하는데 사용
        // compareTo 주어진 객체를 자신과 비교
        //결과가 같으면 0, 오른쪽이 크면 음수 -, 왼쪽이크면 양수 +


        //Comparator 기본 정렬기준 외에 다른 기준으로 정렬하고자 할때 사용
        //Compare 결과가 0이면 같은것, 양수면 왼쪽이 크고, 음수면 오른쪽이 크다

        String[] strArr = {"cat", "Dog", "lion", "tiger"};
        Arrays.sort(strArr);
        System.out.println("strArray : " + Arrays.toString(strArr));// 대문자,소문자 순 정렬 후 알파벳 순

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);//대소문자 구분 안함
        System.out.println("strArray ignoreCase : " + Arrays.toString(strArr));
        Arrays.sort(strArr, new Descending());
        System.out.println("strArray Descending : " + Arrays.toString(strArr));
    }


    public class Descending implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Comparable && o2 instanceof Comparable) {
                Comparable c1 = (Comparable) o1;
                Comparable c2 = (Comparable) o2;
                return c1.compareTo(c2) * -1; // -1을 곱해서 역방향으로 변경
            }
            return -1;
        }
    }


    public void printHashMap() {
        //Map 인터페이스를 구현. 데이터를 키와 값의 쌍으로 저장
        //HashMap은 HashTable의 신버전

        //순서를 유지하려면 LinkedHashMap 클래스를 사용

        //TreeMap 범위검색과 정렬에 유리한 컬렉션 클래스
        //HashMap보다 데이터 추가,삭제에 시간이 더 걸린다
        //TreeSet과 비슷
        //저장은 put, 가져오기는 get
        //1.키로 해시함수를 호출해서 해시코드를 얻는다
        //2.해시코드에 대응하는 링크드리스트를 배열에서 찾는다.
        //3. 링크드 리스트에서 키와 일치하는 데이터를 찾는다.
        //해시함수는 같은 키에 대해 항상 같은 해시코드를 반환해야한다.
        //서로 다른 키일지라도 같은 값의 해시코드를 반환할 수도 있다.

        HashMap<Integer,String> map = new HashMap();
        map.put(1,"1234");
        map.put(3,"44444");
        map.put(2,"12678");
        System.out.println("map"+map);
        map.put(5,"ssdfg234");
        System.out.println("map"+map);

        Set set = map.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext()){
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("이름 : "+e.getKey() + ", 점수 :"+ e.getValue());
        }


        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("id와 pw를 입력하세요.");
            System.out.println("id:");
            String id = scanner.nextLine().trim();

            System.out.println("password :");
            String password = scanner.nextLine().trim();
            System.out.println();

            if(!map.containsKey(id)){
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해 주세요.");
                continue;
            }
            if(!(map.get(id).equals(password))){
                System.out.println("비밀번호가 일치하지 않습니다.다시 입력해 주세요.");
            }else{
                System.out.println("비밀번호와 아이디가 일치합니다.");
                break;
            }//while

            HashMap hashMap = new HashMap();
            hashMap.put("김자바",90);
            hashMap.put("김자바",100);
            hashMap.put("리자바",100);
            hashMap.put("강자바",80);
            hashMap.put("최자바",90);
            hashMap.put("쟤자바",60);

            Set set2 = hashMap.entrySet();
            Iterator iter = set2.iterator();

            while(iter.hasNext()){
                Map.Entry e = (Map.Entry) iter.next();
                System.out.println("이름: "+e.getKey()+",점수: "+e.getValue());
            }

            set2 = hashMap.keySet();
            System.out.println("참가자 명단 :"+set2);

            Collection values = hashMap.values();
            iter = values.iterator();

            int total = 0;

            while (iter.hasNext()){
                Integer i = (Integer) iter.next();
                total+=i;
            }
            System.out.println("총점:"+total);
            System.out.println("평균:"+(float)total/set.size());
            System.out.println("최고점:"+Collections.max(values));
            System.out.println("최저점:"+Collections.min(values));

            String[] data = {"A","K","A","K","D","K","K","K","Z","D"};

            HashMap map2 = new HashMap();

            for(int i =0; i<data.length; i++){
                if(map2.containsKey(data[i])){
                    int value = (int)map2.get(data[i]);
                    map2.put(data[i],value+1);
                }
                else{
                    map2.put(data[i],1);
                }
            }
            Iterator iter2 = map2.entrySet().iterator();
            while (iter2.hasNext()){
                Map.Entry entry = (Map.Entry) iter2.next();
                int value = (int)entry.getValue();
                System.out.println(entry.getKey() + ":"
                + printBar("#",value)+" "+value);
            }

        }
    }
    /*지네릭스란?
    컴파일시 타입을 체크해주는 기능
   ArrayList<Tv> tvList = new ArrayList<Tv>(); ->TV 객체만 저장할 수 있는 ArrayList
   지네릭스가 있기 전에는 Tv 말고 다른걸 넣어도 잡아낼 방법이 없었다.

    tvList.add(new Tv()); ok
    tvList.add(new Audio()); // 컴파일 에러, Tv 외에 다른 타입은 저장 불가

    ArrayList list = new ArrayList();
    list.add(10);
    list.add(20);
    list.add("30"); //String을 넣음

    Integer i = (Integer)list.get(2);
    //컴파일 에러 없음 why? Object 타입으로 반환하기 때문에, Integer 로 형변환이 가능하다
    하지만 실행을 시키면 실제로 들어있는것은 String 이기 때문에 ClassCastException 이 발생
//

    String i = (String)list.get(2); //형변환 생략 가능

//실행시 에러가 나는거 보단 컴파일시 에러나는것이 더 낫다
//지네릭스를 쓰게 되면 실행시 발생하는 에러를 컴파일시 잡아준다.
//그리고 꺼낼때는 원래 반환하는 타입이 Object 타입이라서 형변환을 해줬어야하는데, 형변환을 생략 할 수 있다.
    System.out.println(list);
    지네릭스 덕분에 타입체크가 강화됨
    지네릭스 도입 이후에는 타입 체크를 해주는 것이 좋다
    타입변수 대신 실제 타입을 지정하면, 형변환 생략 가능하다.

   */

//12.2-----------------타입 변수 -----------------
    /*
    * 클래스를 작성할 때, Object 타입 대신 타입변수(E)를 선언해서 사용
    * 일반클래스였던 클래스들이 지네릭클래스로 바뀐 클래스들이 있다. ( Object 클래스를 포함한 클래스들 )
    * 기본적으로 T(Type) 나 E(Element) 를 많이 쓴다
    *
    *
    *객체를 생성시, 타입변수E 대신 실제 타입을 지정(대입)해줘야한다
    * ArrayList<Tv> tvList = new ArrayList<Tv>();
    * 참조변수, 생성자 의 타입변수 일치해야한다
    */


    public int calc(int[] prices, int[] discounts) {
        List<Integer> priceList = new ArrayList<>();
        for(int i:prices) {
            priceList.add(i);
        }
        Collections.sort(priceList,Collections.reverseOrder());

        List<Integer> discountsList = new ArrayList<>();
        for(int i:discounts) {
            discountsList.add(i);
        }
        Collections.sort(discountsList,Collections.reverseOrder());

        Iterator priceIter = priceList.iterator();
        Iterator discountIter = discountsList.iterator();

        List<Integer> discountedList = new ArrayList<>();

        while (priceIter.hasNext()&&discountIter.hasNext()){
            int discountedPrice =  ((int)priceIter.next()*(int)discountIter.next())/100;
            System.out.println("discountedPrice : "+discountedPrice);
            discountedList.add(discountedPrice);
        }

        System.out.println("원래가격 : "+priceList);
        System.out.println("할인율 : "+discountsList);
        System.out.println("할인적용 가격 :"+discountedList);

        int answer = 0;
        for(int i =0; i<discountedList.size(); i++){
                int finallPrice = priceList.get(i) - discountedList.get(i);
                priceList.set(i,finallPrice);
                System.out.println("finallPrice:"+finallPrice);
        }

        for(int price:priceList){
            answer += price;
        }
                System.out.println("answer:"+answer);

//        int answer = 0;
        return answer;
    }

    public String[] calc2(String s) {
        //끝이랑, 다음끼리 비교
//        String prefix = s.substring(0,1);
//        String suffix = (s.substring(s.length()));
//        if(prefix.equals(suffix)){
//
//        };

        String prefix = s.substring(0,1);
        String suffix = s.substring(s.length()-1);

        for(int i = 0; i<s.length(); i++){
            if(!prefix.equals(suffix)){
                prefix += s.substring(0,i);

            }
        }

        String[] answer = {};

        return answer;
    }
}

