package com.fenaco.ua.ufarevue.model;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AusgabeController {

    @Autowired
    AusgabeService ausgabeService;

    @RequestMapping("/showAusgaben")
    public ModelAndView findAusgaben() {
        var ausgaben = ausgabeService.findAll();
        var params = new HashMap<String, Object>();
        params.put("ausgaben", ausgaben);
        return new ModelAndView("showAusgaben", params);
    }

}
