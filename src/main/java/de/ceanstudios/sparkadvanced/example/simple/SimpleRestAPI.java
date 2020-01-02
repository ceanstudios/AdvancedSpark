package de.ceanstudios.sparkadvanced.example;

import de.ceanstudios.sparkadvanced.AdvancedSpark;
import de.ceanstudios.sparkadvanced.annotation.mapping.GetMapping;
import de.ceanstudios.sparkadvanced.annotation.mapping.PostMapping;
import de.ceanstudios.sparkadvanced.annotation.parameter.RequestParam;

public class SimpleRestAPI {


    public static void main(String[] args) {
        AdvancedSpark advancedSpark = new AdvancedSpark("localhost", 8080);
        advancedSpark.init();

        advancedSpark.registerController(new SimpleRestAPI());
    }

    @GetMapping(uri = "/test/get/:name")
    public void getTest (@RequestParam(name = ":name") String name) {
        System.out.println(name);
    }

    @PostMapping(uri = "")

}
