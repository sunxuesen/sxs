package com.cy.pj.sys.dao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * 基于此DAO接口操作sys_role_menus表
 * @author Administrator
 */
@Mapper
public interface SysRoleMenuDao {
	
	//List<Integer> findMenuIdsByRoleId(Integer id);
	/**
	  * 将角色和菜单的关系数据写入到数据库
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	int insertObjects(
			@Param("roleId") Integer roleId,
			@Param("menuIds")Integer[] menuIds);
	
	/**
	  * 基于角色id删除角色和菜单关系数据
	 * @param id
	 * @return
	 */
	 @Delete("delete from sys_role_menus where role_id=#{id}")
	 int deleteObjectsByRoleId(Integer id);
	 
	 /**
	  * 基于菜单id删除角色菜单关系数据
	  * @param id
	  * @return
	  */
	 @Delete("delete from sys_role_menus where menu_id=#{id}")
	 int deleteObjectsByMenuId(Integer id);
}







