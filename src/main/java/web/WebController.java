package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class WebController {

    @RequestMapping("/searchbeers")
    public
    @ResponseBody
    ArrayList<BeerInfo> searchBeers(@RequestParam(value="breweryname", defaultValue="The Cannery", required = false) String bname,
                      HttpServletResponse httpResponse) {

        AccessDatabase accessDB = new AccessDatabase();
        String[] searchParams = new String[1];
        searchParams[0] = bname;
        ArrayList<BeerInfo> beers;
        try {
            beers = accessDB.searchBeers(searchParams);
        } catch (Exception e) {
            beers = null;
        }

        return beers;
    }
}
