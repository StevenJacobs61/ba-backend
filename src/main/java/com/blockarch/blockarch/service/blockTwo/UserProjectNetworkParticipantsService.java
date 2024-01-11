package com.blockarch.blockarch.service.blockTwo;

import com.blockarch.blockarch.model.project.UserProjectNetworkParticipantsDTO;

import java.util.List;

public interface UserProjectNetworkParticipantsService {
    UserProjectNetworkParticipantsDTO createUserProjectNetworkParticipants(UserProjectNetworkParticipantsDTO userProjectNetworkParticipantsDTO);
    List<UserProjectNetworkParticipantsDTO> getAllUserProjectNetworkParticipants();
    UserProjectNetworkParticipantsDTO getUserProjectNetworkParticipantsById(Long id);
    UserProjectNetworkParticipantsDTO updateUserProjectNetworkParticipants(Long id, UserProjectNetworkParticipantsDTO updatedFields);
    void deleteUserProjectNetworkParticipants(Long id);
}
