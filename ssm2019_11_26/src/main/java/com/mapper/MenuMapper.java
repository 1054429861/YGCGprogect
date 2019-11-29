package com.mapper;

import com.domain.Menu;
import com.domain.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {
    List<Menu> selectUserMenu(User user);
}