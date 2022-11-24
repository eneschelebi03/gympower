package com.example.gympower.service;

import com.example.gympower.model.dto.ActiveOfferDTO;
import com.example.gympower.model.mapper.ExclusiveOfferMapper;
import com.example.gympower.repository.ExclusiveOfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExclusiveOfferService {

    private final ExclusiveOfferRepository exclusiveOfferRepository;

    private final ExclusiveOfferMapper exclusiveOfferMapper;

    public ExclusiveOfferService(ExclusiveOfferRepository exclusiveOfferRepository, ExclusiveOfferMapper exclusiveOfferMapper) {
        this.exclusiveOfferRepository = exclusiveOfferRepository;
        this.exclusiveOfferMapper = exclusiveOfferMapper;
    }

    public List<ActiveOfferDTO> getActiveOffers() {
        return this.exclusiveOfferRepository.findAllByIsActive(true).stream()
                .map(exclusiveOfferMapper::offerToActiveOfferDto)
                .collect(Collectors.toList());
    }


}
