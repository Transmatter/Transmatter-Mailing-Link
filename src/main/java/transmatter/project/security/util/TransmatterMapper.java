package transmatter.project.security.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import transmatter.project.security.authentication.dto.UserAuthDto;
import transmatter.project.security.authentication.dto.UserDto;
import transmatter.project.security.authentication.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface TransmatterMapper {
    TransmatterMapper INSTANCE = Mappers.getMapper(TransmatterMapper.class);

    UserDto getUserDto(User user);
    List<UserDto> getUserDto(List<User> user);

    @Mapping(target = "authorities", expression = "java(user.getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    UserAuthDto getUserAuthDto(User user);
}
