package iaik.at.groupsignature;

import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterUser {

    @GetMapping("/keys")
    public PublicKeyGM keys(){
        return new PublicKeyGM();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register", consumes = "application/json", produces = "application/json")
    //public MainActivity register(@RequestParam(value="name", defaultValue="World") String name){
        //return new MainActivity();
    @ResponseBody
    public MainActivity register(@RequestBody UserMessage userm) {
        return new MainActivity(userm);
    }
}
