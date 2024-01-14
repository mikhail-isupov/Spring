package ru.geekbrains.homework2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final iHelloService helloService;
    private final iView view;

    public HelloController(iHelloService helloService, iView view){
        this.helloService = helloService;
        this.view = view;
    }

    /**
     * Генерация приветсвенного сообщения.
     * @return сообщение, обернутое в html код
     */
    @GetMapping("/")
    public String hello(){
        String helloMessage = helloService.getHelloMessage() + ", мир!";
        return view.wrapMessage(helloMessage);
    }

}
