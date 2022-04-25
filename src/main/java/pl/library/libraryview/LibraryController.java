package pl.library.libraryview;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.stream.Collectors;


@Controller
public class LibraryController {

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }


    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(", "));

        Map<String, String> model = Map.of(
                "username", username,
                "authorities", authorities);
        return new ModelAndView("profile", model);
    }
}
