package com.blockarch.blockarch.repository.project;

import com.blockarch.blockarch.model.project.UserProjectNetworkParticipants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProjectNetworkParticipantsRepository extends JpaRepository<UserProjectNetworkParticipants, Long> {
}
