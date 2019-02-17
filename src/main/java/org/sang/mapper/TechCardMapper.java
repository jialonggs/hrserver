package org.sang.mapper;

import org.sang.bean.TechCard;
import org.sang.bean.responseEntity.TechAdded;

import java.util.List;

public interface TechCardMapper {

    Long addTech(TechCard techCard);

    TechCard getByOrderId(Long orderId);

    TechCard getByTechId(Long orderId);

    List<TechCard> getNewByOrderId(Long orderId);

    int updateTechCard(TechCard techCard);

    List<TechAdded> getAll();
}
