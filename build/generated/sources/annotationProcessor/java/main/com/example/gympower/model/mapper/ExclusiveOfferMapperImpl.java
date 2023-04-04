package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.display.ActiveOfferDTO;
import com.example.gympower.model.entity.Picture;
import com.example.gympower.model.entity.products.ExclusiveOffer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T02:22:03+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ExclusiveOfferMapperImpl extends ExclusiveOfferMapper {

    @Override
    public ActiveOfferDTO offerToActiveOfferDto(ExclusiveOffer exclusiveOffer) {
        if ( exclusiveOffer == null ) {
            return null;
        }

        ActiveOfferDTO activeOfferDTO = new ActiveOfferDTO();

        activeOfferDTO.setPictureUrl( exclusiveOfferExclusivePictureUrl( exclusiveOffer ) );
        activeOfferDTO.setPictureTitle( exclusiveOfferExclusivePictureTitle( exclusiveOffer ) );
        activeOfferDTO.setCategory( discountedCategories( exclusiveOffer ) );

        return activeOfferDTO;
    }

    private String exclusiveOfferExclusivePictureUrl(ExclusiveOffer exclusiveOffer) {
        if ( exclusiveOffer == null ) {
            return null;
        }
        Picture exclusivePicture = exclusiveOffer.getExclusivePicture();
        if ( exclusivePicture == null ) {
            return null;
        }
        String url = exclusivePicture.getUrl();
        if ( url == null ) {
            return null;
        }
        return url;
    }

    private String exclusiveOfferExclusivePictureTitle(ExclusiveOffer exclusiveOffer) {
        if ( exclusiveOffer == null ) {
            return null;
        }
        Picture exclusivePicture = exclusiveOffer.getExclusivePicture();
        if ( exclusivePicture == null ) {
            return null;
        }
        String title = exclusivePicture.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }
}
