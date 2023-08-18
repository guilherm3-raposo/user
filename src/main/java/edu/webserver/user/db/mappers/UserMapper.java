package edu.webserver.user.db.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.webserver.user.model.User;

@Mapper
public interface UserMapper {

    public User getUser(final int id);

    public int putUser(final User user);

    public String getPassword(@Param("id") final int id);

    public void updatePassword(@Param("id") final int id, @Param("password") final String password);

}
