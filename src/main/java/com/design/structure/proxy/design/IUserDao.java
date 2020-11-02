package com.design.structure.proxy.design;

/**
 * @author wangyuj
 * @date 2020/11/2
 **/
public interface IUserDao {
    @Select("Select USER_ID form T_USER where USER_ID=#{userId}")
    String selectById(String userId);
}
