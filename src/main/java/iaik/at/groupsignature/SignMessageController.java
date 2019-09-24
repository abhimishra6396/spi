package iaik.at.groupsignature;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignMessageController {

    @RequestMapping("/signmsg")
    public MainActivity signmsg(@RequestParam(value="name", defaultValue="World") String name){
        return new MainActivity();
    }
}
