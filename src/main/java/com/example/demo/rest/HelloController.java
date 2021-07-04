package com.example.demo.rest;

import com.example.demo.service.DataStructure;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    DataStructure dataStructure = new DataStructure();
    @GetMapping("/comparable")
    public String comparable(Model model){
        model.addAttribute("data","comparable");
        dataStructure.printComparable();
        return "hello";
    }

    @GetMapping("/hello")
    public String Hello(Model model){
        model.addAttribute("data","hello");
        dataStructure.printList();
        dataStructure.printLinkedList();
        dataStructure.printArrayList();
        dataStructure.printQueueStackBasic();
        dataStructure.printTreeSet();
        String expression = "((2+3)*1)+3";
        dataStructure.printStack(expression);
        dataStructure.printIterator();
        dataStructure.printArrays();
        return "hello";
    }

    @GetMapping("/set")
    public String treeSet(Model model){
        model.addAttribute("data","treeSet");
        dataStructure.printTreeSet();
        dataStructure.printHashSet();
        return "set";
    }

    @GetMapping("/queue")
    public String queue(Model model){
        model.addAttribute("data","queue");
        dataStructure.printQueue();
        return "queue";
    }

    @GetMapping("/hashmap")
    public String hashMap(Model model){
        model.addAttribute("data","hashmap");
        dataStructure.printHashMap();
        return "hashMap";
    }

    @GetMapping("/calc")
    public String calc(Model model){
        model.addAttribute("data","hashmap");
        int[] prices = {13000, 88000, 10000};
        int[] discounts = {30, 20,10};
        dataStructure.calc(prices,discounts);
        return "calc";
    }

    @GetMapping("/calc2")
    public String calc2(Model model){
        model.addAttribute("data","hashmap");
    String s = "abcxyasdfasdfxyabc";
        dataStructure.calc2(s);
        return "calc";
    }

    @GetMapping("/success")
    public String success(Model model){
        System.out.println("success!!!");
        return "filtered";
    }



    @GetMapping("/filtered/success")
    public String filteredSuccess(Model model){
        System.out.println("filtered success!!!");
        return "filtered";
    }

    @GetMapping("/filtered/hello")
    public String filteredHello(Model model){
        System.out.println("hello filter");
        dataStructure.printArrays();
        return "hello";
    }
}
