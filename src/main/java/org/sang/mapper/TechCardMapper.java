package org.sang.mapper;

import org.sang.bean.TechCard;

public interface TechCardMapper {

    Long addTech(TechCard techCard);

    TechCard getByOrderId(Long orderId);

    int updateTechCard(TechCard techCard);
}
