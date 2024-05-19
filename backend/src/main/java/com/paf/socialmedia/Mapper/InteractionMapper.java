package com.pafnew.PAFassigment.Mapper;

import com.pafnew.PAFassigment.Dto.InteractionDto;
import com.pafnew.PAFassigment.Entity.Interaction;

public class InteractionMapper {

    public static InteractionDto mapToInteractionDto(Interaction interaction) {
        return new InteractionDto(

                interaction.getId(),
                interaction.getContent(),
                interaction.getDate(),
                interaction.getTime()

        );


    }
    public static Interaction mapToInteraction(InteractionDto interactionDto){
        return new Interaction(

                interactionDto.getContent(),
                interactionDto.getDate(),
                interactionDto.getTime()

        );
    }
}
