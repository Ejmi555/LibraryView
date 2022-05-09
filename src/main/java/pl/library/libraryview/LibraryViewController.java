package pl.library.libraryview;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class LibraryViewController {

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

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/books/add")
    public ModelAndView addBooksForm() {
        return new ModelAndView("addBook");
    }

    @GetMapping("/readers/add")
    public ModelAndView addReaderForm() {
        return new ModelAndView("addReader");
    }

    @GetMapping("/books/find")
    public ModelAndView findBookView() {
        return new ModelAndView("findBook");
    }

    @GetMapping("/readers/find")
    public ModelAndView findReaderView() {
        return new ModelAndView("findReader");
    }

    @GetMapping("/accessDenied")
    public ModelAndView accessDenied() { return new ModelAndView("accessDenied"); }

    @GetMapping("/loans/lend")
    public ModelAndView addLoanForm() {
        return new ModelAndView("addLoan");
    }

}
