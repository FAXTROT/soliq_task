package soliq.task.model.mapper;

import org.springframework.beans.BeanUtils;
import soliq.task.model.dto.ClientDTO;
import soliq.task.model.entity.ClientEntity;

public class ClientMapper extends BaseMapper<ClientEntity, ClientDTO> {
    @Override
    public ClientEntity convertToEntity(ClientDTO dto, Object... args) {
        ClientEntity entity = new ClientEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }
    
    @Override
    public ClientDTO convertToDto(ClientEntity entity, Object... args) {
        ClientDTO clientDTO = new ClientDTO();
        if (entity != null) {
            BeanUtils.copyProperties(entity, clientDTO);
        }
        return clientDTO;
    }
}
