package com.hhj.easycodetest.service;

import com.hhj.easycodetest.entity.TbUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TbUser)表服务接口
 *
 * @author makejava
 * @since 2024-04-11 09:11:45
 */
public interface TbUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUser queryById(Integer id);

    /**
     * 查询所有用户信息的方法
     *
     * @param tbUser 一个TbUser对象，用于可能的查询条件筛选
     * @return 返回一个TbUser类型的列表，包含所有满足条件的用户信息
     */
    List<TbUser> qeryAll();

    /**
     * 分页查询
     *
     * @param tbUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbUser> queryByPage(TbUser tbUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    TbUser insert(TbUser tbUser);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    TbUser update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
