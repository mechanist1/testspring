package exemplebrojla.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class studentcontroller {

    @GetMapping
    public List<String> findstudents(){
        return( List.of(
                "Ahmed",
                "Ilyess"

        ));
    }
}
