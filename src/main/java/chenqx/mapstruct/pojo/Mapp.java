package chenqx.mapstruct.pojo;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-13 15:31
 **/
@Mapper
public interface Mapp {
    Mapp INSTANCE = Mappers.getMapper(Mapp.class);
    Child domain2dto(Parent person);

    List<Child> convert(List<Parent> person);
}
