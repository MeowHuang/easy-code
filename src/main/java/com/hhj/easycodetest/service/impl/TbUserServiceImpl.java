package com.hhj.easycodetest.service.impl;

import com.hhj.easycodetest.dao.TbUserDao;
import com.hhj.easycodetest.entity.TbUser;
import com.hhj.easycodetest.service.TbUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (TbUser)表服务实现类
 *
 * @author makejava
 * @since 2024-04-11 09:11:46
 */
@Service("tbUserService")
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserDao tbUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbUser queryById(Integer id) {
        return this.tbUserDao.queryById(id);
    }

    /**
     * 查询所有用户信息。
     *
     * @param tbUser TbUser对象，用于可能的查询条件筛选。
     * @return 返回一个TbUser对象的列表，包含所有满足条件的用户信息。
     */
    @Override
    public List<TbUser> qeryAll() {
        return this.tbUserDao.queryAll();
    }

    /**
     * 分页查询
     *
     * @param tbUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbUser> queryByPage(TbUser tbUser, PageRequest pageRequest) {
        long total = this.tbUserDao.count(tbUser);
        return new PageImpl<>(this.tbUserDao.queryAllByLimit(tbUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbUser insert(TbUser tbUser) {
        // 设置插入时间为当前系统时间
        tbUser.setCreateTime(new Date());
        this.tbUserDao.insert(tbUser);
        return tbUser;
    }

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbUser update(TbUser tbUser) {
        // 设置更新时间为当前系统时间
        tbUser.setUpdateTime(new Date());
        this.tbUserDao.update(tbUser);
        return this.queryById(tbUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbUserDao.deleteById(id) > 0;
    }
}
