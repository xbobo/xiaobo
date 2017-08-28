package com.xiaobo.cn.shiro.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiaobo.cn.common.annotation.SysLog;
import com.xiaobo.cn.common.controller.AbstractController;
import com.xiaobo.cn.common.entity.R;
import com.xiaobo.cn.shiro.entity.SysMenuEntity;
import com.xiaobo.cn.shiro.service.SysMenuService;

/**
 * 系统菜单controller
 *
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController {

	@Resource
	private SysMenuService sysMenuService;
	
	/**
	 * 用户菜单
	 * @return
	 */
	@RequestMapping("/user")
	public R user(){
		return sysMenuService.listUserMenu(getUserId());
	}
	
	/**
	 * 菜单列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public List<SysMenuEntity> listMenu(@RequestParam Map<String, Object> params) {
		return sysMenuService.listMenu(params);
	}
	
	/**
	 * 选择菜单(添加、修改)
	 * @return
	 */
	@RequestMapping("/select")
	public R select() {
		return sysMenuService.listNotButton();
	}
	
	/**
	 * 新增菜单
	 * @param menu
	 * @return
	 */
	@SysLog("新增菜单")
	@RequestMapping("/save")
	public R save(@RequestBody SysMenuEntity menu) {
		return sysMenuService.saveMenu(menu);
	}

	/**
	 * 查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R info(@RequestBody Long id) {
		return sysMenuService.getMenuById(id);
	}
	
	/**
	 * 修改菜单
	 * @param menu
	 * @return
	 */
	@SysLog("修改菜单")
	@RequestMapping("/update")
	public R update(@RequestBody SysMenuEntity menu) {
		return sysMenuService.updateMenu(menu);
	}
	
	/**
	 * 删除菜单
	 * @param id
	 * @return
	 */
	@SysLog("删除菜单")
	@RequestMapping("/remove")
	public R remove(@RequestBody Long[] id) {
		return sysMenuService.batchRemove(id);
	}
	
}