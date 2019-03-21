package com.sr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sr.entity.DownFile;
import com.sr.entity.UserInfo;

@Mapper
public interface DownFileDao{
	
	/**
	 * 查询所有下载资源
	 * 按条件查询下载资源
	 * @return
	 */
	public List<DownFile> queryDownFile(Integer downtypeid,String fileName,Integer fileid,String userid,Integer filetype,Integer upfilestate);
	
	/**
	 * 根据ID查询信息
	 * @param fileid
	 * @return
	 */
	public DownFile queryById(Integer fileid);
	
	/**
	 * 精品推荐(按次数多少推荐)
	 * @return
	 */
	public List<DownFile> recommend();
	
	/**
	 * 最新上传
	 * @return
	 */
	public List<DownFile> BynewTime();

	/**
	 * 根据资源ID查询作者信息
	 * @param fileid
	 * @return
	 */
	public DownFile queryUser(Integer fileid);
	
	/**
	 * 根据用户ID查询资源
	 * @param userid
	 * @return
	 */
	public List<DownFile> queryByUseridfiles(String userid,Integer fileid);

	/**
	 * 根据用户ID查询排名信息
	 * @param userid
	 * @return
	 */
	public List<Map<String,Object>> queryPaiming(String userid);
	
	/**
	 * 添加资源
	 * @param df
	 * @return
	 */
	public int addfile(DownFile df);
	
	/**
	 * 查询他的资源
	 * @param uid
	 * @return
	 */
	public List<Map<String,Object>> queryHeResour(String uid,Integer pageindex);
	
	/**
	 * 查询他用户信息
	 * @param uid
	 * @return
	 */
	public UserInfo queryHeUser(String uid);
}
