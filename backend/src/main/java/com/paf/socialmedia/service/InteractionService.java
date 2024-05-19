package com.pafnew.PAFassigment.Service;

import com.pafnew.PAFassigment.Dto.InteractionDto;

import java.util.List;


public interface InteractionService {

    InteractionDto createInteraction(InteractionDto interactionDto);

    InteractionDto getInteractionById(Long interactionId );

    List<InteractionDto> getAllInteractions();

    InteractionDto updateInteraction(Long interactionId, InteractionDto updatedInteraction);
    void deleteInteraction(Long interactionId);

}
