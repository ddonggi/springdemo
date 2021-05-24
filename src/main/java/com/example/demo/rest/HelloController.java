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

    @GetMapping("/treeSet")
    public String treeSet(Model model){
        model.addAttribute("data","treeSet");
        dataStructure.printTreeSet();
        return "treeSet";
    }
    @GetMapping("/queue")
    public String queue(Model model){
        model.addAttribute("data","queue");
        dataStructure.printQueue();
        return "queue";
    }
}
