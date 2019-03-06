package com.fenaco.ua.ufarevue.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AusgabeService {
    @Autowired
    private AusgabeRepository ausgabeRepository;

    public List<Ausgabe> findAll() {
        var ausgabe = (List<Ausgabe>) ausgabeRepository.findAll();
        return ausgabe;
    }
}
