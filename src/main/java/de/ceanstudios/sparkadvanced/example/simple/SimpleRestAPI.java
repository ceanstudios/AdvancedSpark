package de.ceanstudios.sparkadvanced.example.simple;

import de.ceanstudios.sparkadvanced.AdvancedSpark;
import de.ceanstudios.sparkadvanced.annotation.mapping.GetMapping;
import de.ceanstudios.sparkadvanced.annotation.mapping.PostMapping;
import de.ceanstudios.sparkadvanced.annotation.parameter.RequestBody;
import de.ceanstudios.sparkadvanced.annotation.parameter.RequestHeader;
import de.ceanstudios.sparkadvanced.annotation.parameter.RequestParam;
import de.ceanstudios.sparkadvanced.response.AdvancedResponse;

/**
 * It is recommended to use tools like Postman for testing.
 */
public class SimpleRestAPI {


    public static void main(String[] args) {
        AdvancedSpark advancedSpark = new AdvancedSpark("localhost", 8080);
        advancedSpark.init();

        advancedSpark.registerController(new SimpleRestAPI());
    }

    @GetMapping(uri = "/test/get/:name")
    public AdvancedResponse getTest (@RequestParam(name = ":name") String name, @RequestHeader(name = "Content-Type") String contentType) {
        System.out.println(contentType);
        System.out.println(name);
        return AdvancedResponse.ok();
    }

    @PostMapping(uri = "/test/post")
    public AdvancedResponse getPost (@RequestBody TestBody testBody) {
        System.out.println(testBody.getData());
        return AdvancedResponse.ok(testBody);
    }

}
