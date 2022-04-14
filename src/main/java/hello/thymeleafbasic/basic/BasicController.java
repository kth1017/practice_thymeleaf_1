package hello.thymeleafbasic.basic;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/basic")
public class BasicController {

    // 1
    @GetMapping("text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello");
        return "basic/text-basic";
    }
    //2
    @GetMapping("text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "<br>Hello<br>");
        return "basic/text-unescaped";
    }

    //3
    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        ArrayList<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        HashMap<String , User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);

        return "basic/variable";
    }

    @Data
    static class User {
        private String Username;
        private int age;

        public User(String username, int age) {
            Username = username;
            this.age = age;
        }
    }
}