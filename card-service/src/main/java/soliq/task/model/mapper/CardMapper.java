package soliq.task.model.mapper;

import org.springframework.beans.BeanUtils;
import soliq.task.model.dto.CardDTO;
import soliq.task.model.entity.CardEntity;

public class CardMapper extends BaseMapper<CardEntity, CardDTO> {
    
    @Override
    public CardEntity convertToEntity(CardDTO dto, Object... args) {
        CardEntity entity = new CardEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }
    
    @Override
    public CardDTO convertToDto(CardEntity entity, Object... args) {
        CardDTO CardDTO = new CardDTO();
        if (entity != null) {
            BeanUtils.copyProperties(entity, CardDTO);
        }
        return CardDTO;
    }
    
}
