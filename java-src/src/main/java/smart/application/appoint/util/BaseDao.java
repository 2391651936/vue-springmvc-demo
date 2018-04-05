package smart.application.appoint.util;

import org.springframework.stereotype.Component;
import smart.application.appoint.dao.BaseMapper;

@Component
public class BaseDao<T> {

    /**
     * 公共保存方法
     * @param baseMapper service 对象
     * @param t 要保存的对象
     * @return CREATE_OK：成功，APPEAR_ERROR：失败
     */
    public String save(BaseMapper<T> baseMapper, T t) {
        try {
            baseMapper.save(t);
            return StaticUtil.CREATE_OK;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StaticUtil.APPEAR_ERROR;
    }

    /**
     * 公共删除方法
     * @param baseMapper service 对象
     * @param id 要删除的 id
     * @return CREATE_OK：成功，APPEAR_ERROR：失败
     */
    public String deleteById(BaseMapper<T> baseMapper, int id) {
        try {
            baseMapper.deleteById(id);
            return StaticUtil.CREATE_OK;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StaticUtil.APPEAR_ERROR;
    }

    /**
     * 公共修改方法
     * @param baseMapper service 对象
     * @param t 要修改的对象
     * @return CREATE_OK：成功，APPEAR_ERROR：失败
     */
    public String update(BaseMapper<T> baseMapper, T t) {
        try {
            baseMapper.update(t);
            return StaticUtil.CREATE_OK;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StaticUtil.APPEAR_ERROR;
    }
}
