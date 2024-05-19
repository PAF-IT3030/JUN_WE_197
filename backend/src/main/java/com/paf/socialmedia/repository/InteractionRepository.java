package com.pafnew.PAFassigment.Repository;

import com.pafnew.PAFassigment.Entity.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Long> {
}
