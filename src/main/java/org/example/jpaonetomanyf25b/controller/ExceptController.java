package org.example.jpaonetomanyf25b.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("exp/")
public class ExceptController {

    @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/file/{filename}")
    public String getFile(@PathVariable String filename){
        try (FileInputStream fs = new FileInputStream("c:/AFILE/" + filename)) {
            return new String(fs.readAllBytes());
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/div/{divnum1}/{divnum2}")
    public int getDivNum(@PathVariable int divnum1, @PathVariable int divnum2){
        int i1 = divnum1 / divnum2;
        return i1;
    }

    @GetMapping("/loop/{loopnum}")
    public int getLoopNum(@PathVariable int loopnum){
        int x = 0;
        for (int i = 0; i < loopnum; i++) {
            x++;
        }
        return x;
    }


}
