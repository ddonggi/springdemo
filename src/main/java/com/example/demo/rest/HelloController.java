package com.example.demo.rest;

import com.example.demo.service.LinkedListPrac;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    LinkedListPrac linkedListPrac = new LinkedListPrac();

    @GetMapping("/hello")
    public String Hello(Model model){
        model.addAttribute("data","hello");
        linkedListPrac.printList();
        linkedListPrac.printLinkedList();
        linkedListPrac.printArrayList();
        return "hello";
    }

    @GetMapping("/treeSet")
    public String treeSet(Model model){
        model.addAttribute("data","treeSet");
        linkedListPrac.printTreeSet();
        return "treeSet";
    }

}
