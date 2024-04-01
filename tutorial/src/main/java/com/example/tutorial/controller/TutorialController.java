package com.example.tutorial.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.tutorial.model.Tutorial;
import com.example.tutorial.repository.TutorialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    TutorialRepository tutorialRepository;

    Logger log = LoggerFactory.getLogger(TutorialController.class);

    /**
     * API per ottenere tutti i `tutorials`, eventualmente filtrati per `title`
     * @param title (opzionale) titolo del tutorial che si vuole recuperare
     * @return una lista di {@link Tutorial}
     */
    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        List<Tutorial> tutorials = new ArrayList<Tutorial>();
        log.info("GET /tutorials ");
        if (title == null)
            // In questo caso assegno direttamente il risultato alla lista
            tutorials = tutorialRepository.findAll();
        else
            // In questo caso costriusco la lista usando forEach
            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

        if (tutorials.isEmpty()) {
            // Nessun contenuto da ritornare
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }

    /**
     * API per recuperare un tutorial a partire dal suo id
     * @param id    (Obbligatorio) ID del tutorial da recuperare
     * @return  un oggetto di tipo Tutorial
     */
    @GetMapping("/tutorials/{id}")
    @ResponseBody
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        log.info("Request GET /tutorials/" + id);
        Tutorial tutorial = tutorialRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Tutorial Not Found With Id = " + id));
        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        Tutorial _tutorial = tutorialRepository.save(
                new Tutorial(tutorial.getTitle(), tutorial.getDescription(), true));
        return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
    }

    /**
     * API per la modifica di un tutorial. Occorre specificare in Path l'ID del tutorial
     * e nel payload i valori dell'oggetto che andranno a modificare quello già
     * presente sulla tabella.
     * @param id    (Obbligatorio) ID del tutorial da modificare
     * @param tutorial  Oggetto {@link Tutorial}
     * @return  un oggetto di tipo {@link Tutorial}
     */
    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        // Recupera il record se presente
        Tutorial _tutorial = tutorialRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Tutorial Not Found with id = " + id));
        // Se presente, sostituisce i campi esistenti con quelli
        // specificati nel payload (body).
        _tutorial.setTitle(tutorial.getTitle());
        _tutorial.setDescription(tutorial.getDescription());
        _tutorial.setPublished(tutorial.isPublished());

        return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        tutorialRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        tutorialRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/tutorials/getPublished")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

        if (tutorials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }
}