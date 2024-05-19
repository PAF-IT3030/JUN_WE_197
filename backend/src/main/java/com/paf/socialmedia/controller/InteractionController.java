package com.pafnew.PAFassigment.Controller;

import com.pafnew.PAFassigment.Dto.InteractionDto;
import com.pafnew.PAFassigment.Service.InteractionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/interactions")

public class InteractionController {

    private InteractionService interactionService;


    //Build add interaction Rest  ApI
    @PostMapping
    public ResponseEntity<InteractionDto> createInteraction(@RequestBody InteractionDto interactionDto){
        InteractionDto savedInteraction = interactionService.createInteraction(interactionDto);
        return new ResponseEntity<>(savedInteraction, HttpStatus.CREATED);
    }

    //Build Get Interaction REST API
    @GetMapping("{id}")
    public ResponseEntity<InteractionDto> getInteractionById(@PathVariable("id") Long interactionId){
        InteractionDto interactionDto = interactionService.getInteractionById(interactionId);
        return ResponseEntity.ok(interactionDto);
    }

    //Build Get All Interactions REST API
    @GetMapping
    public ResponseEntity<Object> getAllInteractions() {
        List<InteractionDto> interactions = interactionService.getAllInteractions();
        return ResponseEntity.ok(interactions);
    }

    //Build Updated Interaction REST API
    @PutMapping("{id}")
    public ResponseEntity<InteractionDto> updateInteraction(@PathVariable("id") Long interactionId,
                                                            @RequestBody InteractionDto updatedInteraction){
        InteractionDto interactionDto = interactionService.updateInteraction(interactionId, updatedInteraction);
        return ResponseEntity.ok(interactionDto);
    }

    //Build Delete Interaction REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInteraction(@PathVariable("id") Long interactionId ){
        interactionService.deleteInteraction(interactionId);
        return ResponseEntity.ok("Interaction Deleted Successfully");
    }

    }


