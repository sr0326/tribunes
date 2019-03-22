package com.cjt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cjt.entity.Bbscomment;
import com.cjt.entity.Bbstype;
import com.cjt.entity.Userinfo;


@Mapper
public interface BbsDao {

	/**
	 * 热门帖子查询
	 * @return
	 */
	@Select("select u.userid, bt.btname,b.bbstitle,u.nickname ,b.bbsid from bbs b left join userinfo u on b.bbsid = u.userid left join bbstype bt on b.bbsid = bt.btid where b.score <100")
	public List<Map<String,Object>> querybbs();
	/**
	 * 推荐帖子
	 * @return
	 */
	@Select("select u.userid,bt.btname,b.bbstitle,u.nickname ,b.bbsid from bbs b left join userinfo u on b.bbsid = u.userid left join bbstype bt on b.bbsid = bt.btid where b.score >=100")
	public List<Map<String,Object>> queryTbbs();
	
	/**
	 * 评论查询
	 * @param bbsid
	 * @return
	 */
	@Select("SELECT u.userid, b.bbsid,u.nickname,b.content,b.pushtime,u.pic from bbscomment b,userinfo u,bbs s where b.userid = u.userid and b.bbsid = s.bbsId and b.bbsid = #{param1}")
	public List<Map<String,Object>> querybbscomment(Integer bbsid);
	/**
	 * 个人博客查询
	 * @param userid
	 * @return
	 */
	@Select("SELECT b.blogTitle,b.blogContent,b.pushtime from blog b,userinfo u where b.userid = u.userid and u.userId = #{param1}")
	public List<Map<String,Object>> querybolg(String userid);
	/**
	 * 排行榜
	 * @return
	 */
	@Select("SELECT nickname,integral  from userinfo  ORDER BY integral DESC")
	public List<Userinfo> qeuryIntegral();
	/**
	 * 
	 * @param parentid
	 * @return
	 */
	@Select("SELECT Btname from bbstype where parentid = #{param1}")
	public List<Bbstype> querytypeTwo(Integer parentid);
	/**
	 * 根据论坛id查询技术问题
	 * @param userid
	 * @return
	 */
	@Select("SELECT b.bbsid, b.score,u.userid,b.bbstitle,b.bbscontent,b.pushtime,u.nickname from  bbs b,userinfo u where b.userid = u.userid and b.bbsid = #{param1}")   
	public List<Map<String,Object>> querybbst(Integer bbsid);	
	/**
	 * 评论
	 * @param b
	 */
	@Insert("INSERT into bbscomment VALUES(null,#{content},#{userid},#{bbsid},now())")
	public void addComment(Bbscomment b);
	
	
	
	
	
	
}
