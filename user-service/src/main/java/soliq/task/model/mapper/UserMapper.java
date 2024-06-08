package soliq.task.model.mapper;

import org.springframework.beans.BeanUtils;
import soliq.task.model.dto.UserDTO;
import soliq.task.model.entity.UserEntity;

public class UserMapper extends BaseMapper<UserEntity, UserDTO> {
    
    @Override
    public UserEntity convertToEntity(UserDTO dto, Object... args) {
        
        UserEntity entity = new UserEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }
    
    @Override
    public UserDTO convertToDto(UserEntity entity, Object... args) {
        
        UserDTO userDTO = new UserDTO();
        if (entity != null) {
            BeanUtils.copyProperties(entity, userDTO);
        }
        return userDTO;
    }
    
}
