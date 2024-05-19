package com.pafnew.PAFassigment.Service.impl;

import com.pafnew.PAFassigment.Dto.InteractionDto;
import com.pafnew.PAFassigment.Entity.Interaction;
import com.pafnew.PAFassigment.Exception.ResourceNotFoundException;
import com.pafnew.PAFassigment.Mapper.InteractionMapper;
import com.pafnew.PAFassigment.Repository.InteractionRepository;
import com.pafnew.PAFassigment.Service.InteractionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InteractionServiceImpl implements InteractionService{

    private final InteractionRepository interactionRepository;

    @Override
    public InteractionDto createInteraction(InteractionDto interactionDto) {
        Interaction interaction = InteractionMapper.mapToInteraction(interactionDto);
        Interaction savedInteraction = interactionRepository.save(interaction);
        return InteractionMapper.mapToInteractionDto(savedInteraction);
    }

    @Override
    public InteractionDto getInteractionById(Long interactionId) {
        Interaction interaction = interactionRepository.findById(interactionId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Interaction not found with id: " + interactionId));
       return InteractionMapper.mapToInteractionDto(interaction);
    }

    @Override
    public List<InteractionDto> getAllInteractions() {
       List<Interaction>interactions = interactionRepository.findAll();
        return interactions.stream()
               // .map((interaction) -> InteractionMapper.mapToInteractionDto(interaction))
                .map(InteractionMapper::mapToInteractionDto)
                .collect(Collectors.toList());
    }

    @Override
    public InteractionDto updateInteraction(Long interactionId, InteractionDto updatedInteraction) {

        Interaction interaction = interactionRepository.findById(interactionId).orElseThrow(
                () -> new ResourceNotFoundException("Interaction  is not exist with given id :" + interactionId)
        );

        interaction.setContent(updatedInteraction.getContent());
        interaction.setDate(updatedInteraction.getDate());
        interaction.setTime(updatedInteraction.getTime());

        Interaction updatedInteractionObj = interactionRepository.save(interaction);
        return InteractionMapper.mapToInteractionDto(updatedInteractionObj);
    }

    @Override
    public void deleteInteraction(Long interactionId) {

        Interaction interaction = interactionRepository.findById(interactionId).orElseThrow(
                () -> new ResourceNotFoundException("Interaction  is not exist with given id :" + interactionId)
        );

        interactionRepository.deleteById(interactionId);

    }


}





