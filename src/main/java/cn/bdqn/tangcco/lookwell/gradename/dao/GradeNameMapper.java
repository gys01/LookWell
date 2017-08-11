package cn.bdqn.tangcco.lookwell.gradename.dao;

/**
 * Created by TYY on 2017/8/4.
 */
public interface GradeNameMapper {
    /**
     * 添加班级名称唯一策略
     * 产品名称 + n个0 + 自增的num
     * 班级名称指定为10位
     * @param projectId
     * @return
     */
    //修改当前编号自加1
    Integer updateNumByProjectId(Integer projectId);

    //取出自加1后的编号
    Integer queryNumByProjectId(Integer projectid);
}
