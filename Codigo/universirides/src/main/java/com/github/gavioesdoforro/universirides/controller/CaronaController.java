package com.github.gavioesdoforro.universirides.controller;

import com.github.gavioesdoforro.universirides.modelo.*;
import com.github.gavioesdoforro.universirides.modelo.enums.*;
import com.github.gavioesdoforro.universirides.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/carona")
public class CaronaController {
    @Autowired
    private IRepositorioCarona repositorioCarona;

    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    @RequestMapping("/")
    public ModelAndView home() {
        List<Carona> listCaronas = repositorioCarona.findAll();
        ModelAndView mav = new ModelAndView("visualizar_caronas");
        mav.addObject("listCaronas", listCaronas);
        return mav;
    }

    @RequestMapping("/new")
    public String newCaronaForm(Map<String, Object> model) {
        Carona carona = new Carona();
        model.put("carona", carona);
        model.put("tipos", Tipo.values());
        model.put("turnos", Turno.values());
        return "nova_carona";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCarona(@ModelAttribute("carona") Carona carona) {
        Usuario usuario = repositorioUsuario.findById((long) 1).get();
        carona.setUsuario(usuario);
        carona.setStatus(Status.Aberto);
        repositorioCarona.save(carona);
        return "redirect:/carona/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateCarona(@ModelAttribute("carona") Carona carona) {
        Usuario usuario = repositorioUsuario.findById((long) 1).get();
        carona.setUsuario(usuario);
        repositorioCarona.save(carona);
        return "redirect:/carona/";
    }

    @RequestMapping("/edit")
    public ModelAndView editCaronaForm(@RequestParam long id, Map<String, Object> model) {
        ModelAndView mav = new ModelAndView("edit_carona");
        Carona carona = repositorioCarona.getOne(id);
        mav.addObject("carona", carona);
        model.put("carona", carona);
        model.put("tipos", Tipo.values());
        model.put("turnos", Turno.values());
        model.put("status", Status.values());
        return mav;
    }

    @RequestMapping("/delete")
    public String deleteCaronaForm(@RequestParam long id) {
        repositorioCarona.deleteById(id);
        return "redirect:/carona/";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Carona> result = repositorioCarona.
                findByBairroContainingIgnoreCaseOrDescricaoContainingIgnoreCase(keyword, keyword);
        ModelAndView mav = new ModelAndView("resultado_busca");
        mav.addObject("result", result);
        return mav;
    }
}
