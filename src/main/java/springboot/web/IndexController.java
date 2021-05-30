package springboot.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.config.auth.LoginUser;
import springboot.config.auth.dto.SessionUser;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
            log.info("현재 로그인 유저 : " + user.getName());
        } else {
            log.info("시작 페이지로 이동합니다");
        }
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model, @LoginUser SessionUser user) {
        log.info("성공했당");
        //model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "list";
    }
}
