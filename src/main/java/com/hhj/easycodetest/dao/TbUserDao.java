package com.hhj.easycodetest.dao;

import com.hhj.easycodetest.entity.TbUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TbUser)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-11 09:11:44
 */
@ApiModel(value = "用户实体类",description = "存放用户表的字段")
public interface TbUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @ApiModelProperty("主键ID")
    TbUser queryById(Integer id);


    /**
     * 查询所有用户信息
     *
     * @return List<TbUser> 返回用户信息列表，列表中包含所有用户的信息。
     */
    List<TbUser> queryAll();

    /**
     * 查询指定行数据
     *
     * @param tbUser 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbUser> queryAllByLimit(TbUser tbUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbUser 查询条件
     * @return 总行数
     */
    long count(TbUser tbUser);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int insert(TbUser tbUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbUser> entities);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

