package com.github.murilloandrade.gfpessoal.controller;

import com.github.murilloandrade.gfpessoal.modelo.*;
import com.github.murilloandrade.gfpessoal.modelo.enums.*;
import com.github.murilloandrade.gfpessoal.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/gastoGanho")
public class GastoGanhoController {
    @Autowired
    private IRepositorioGastoGanho repositorioGastoGanho;

    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    @RequestMapping("/")
    public ModelAndView home() {
        List<GastoGanho> listGastoGanhos = repositorioGastoGanho.findAll();
        double Saldo = repositorioUsuario.findById((long) 1).get().getSaldo();
        ModelAndView mav = new ModelAndView("visualizar_gastoGanho");
        mav.addObject("listGastoGanhos", listGastoGanhos);
        mav.addObject("saldo", Saldo);
        return mav;
    }

    @RequestMapping("/new")
    public String newGastoGanhoForm(Map<String, Object> model) {
        GastoGanho gastoGanho = new GastoGanho();
        model.put("gastoGanho", gastoGanho);
        model.put("tipos", Tipo.values());
        return "novo_gastoGanho";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveGastoGanho(@ModelAttribute("gastoGanho") GastoGanho gastoGanho) {
        Usuario usuario = repositorioUsuario.findById((long) 1).get();
        gastoGanho.setUsuario(usuario);
        gastoGanho.setDataHora(LocalDateTime.now());
        if(gastoGanho.getTipo()==Tipo.Ganho) {
            usuario.setSaldo(usuario.getSaldo() + gastoGanho.getValor());
        } else usuario.setSaldo(usuario.getSaldo() - gastoGanho.getValor());
        repositorioGastoGanho.save(gastoGanho);
        return "redirect:/gastoGanho/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateGastoGanho(@ModelAttribute("gastoGanho") GastoGanho gastoGanho) {
        Usuario usuario = repositorioUsuario.findById((long) 1).get();
        gastoGanho.setUsuario(usuario);
        gastoGanho.setDataHora(LocalDateTime.now());
        if(gastoGanho.getTipo()==Tipo.Ganho) {
            usuario.setSaldo(usuario.getSaldo() + gastoGanho.getValor());
        } else usuario.setSaldo(usuario.getSaldo() - gastoGanho.getValor());
        repositorioGastoGanho.save(gastoGanho);
        return "redirect:/gastoGanho/";
    }

    @RequestMapping("/edit")
    public ModelAndView editGastoGanhoForm(@RequestParam long id, Map<String, Object> model) {
        ModelAndView mav = new ModelAndView("edit_gastoGanho");
        Usuario usuario = repositorioUsuario.findById((long) 1).get();
        GastoGanho gastoGanho = repositorioGastoGanho.getOne(id);
        mav.addObject("gastoGanho", gastoGanho);
        model.put("gastoGanho", gastoGanho);
        model.put("tipos", Tipo.values());
        if(gastoGanho.getTipo()==Tipo.Ganho) {
            usuario.setSaldo(usuario.getSaldo() - gastoGanho.getValor());
        } else usuario.setSaldo(usuario.getSaldo() + gastoGanho.getValor());
        return mav;
    }

    @RequestMapping("/delete")
    public String deleteGastoGanhoForm(@RequestParam long id) {
        Usuario usuario = repositorioUsuario.findById((long) 1).get();
        GastoGanho gastoganho = repositorioGastoGanho.findById(id).get();
        if(gastoganho.getTipo()==Tipo.Ganho) {
            usuario.setSaldo(usuario.getSaldo() - gastoganho.getValor());
        } else usuario.setSaldo(usuario.getSaldo() + gastoganho.getValor());
        repositorioGastoGanho.deleteById(id);
        return "redirect:/gastoGanho/";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<GastoGanho> result = repositorioGastoGanho.
                findByDescricaoContainingIgnoreCase(keyword);
        ModelAndView mav = new ModelAndView("resultado_busca");
        mav.addObject("result", result);
        return mav;
    }
}
