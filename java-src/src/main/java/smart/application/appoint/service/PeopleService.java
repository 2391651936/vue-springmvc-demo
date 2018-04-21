package smart.application.appoint.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import smart.application.appoint.dao.PeopleMapper;
import smart.application.appoint.models.People;
import smart.application.appoint.models.PeopleType;
import smart.application.appoint.util.BaseDao;
import smart.application.appoint.util.StaticUtil;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PeopleService implements PeopleMapper {

    @Resource
    private PeopleMapper peopleMapper;

    @Resource
    private BaseDao<People> baseDao;

    @Override
    public People selectPeopleByUsername(String username) {
        return peopleMapper.selectPeopleByUsername(username);
    }

    @Override
    public People findPeopleByUsername(String username) {
        return peopleMapper.findPeopleByUsername(username);
    }

    @Override
    public People selectPeopleById(int id) {
        return peopleMapper.selectPeopleById(id);
    }

    @Override
    public int countPeopleByPeopleType(int peopleType) {
        return peopleMapper.countPeopleByPeopleType(peopleType);
    }

    @Override
    public List<PeopleType> selectPeopleType() {
        return peopleMapper.selectPeopleType();
    }

    @Override
    public boolean existPeopleByUsername(String username) {
        return peopleMapper.existPeopleByUsername(username);
    }

    @Override
    public List<People> selectPeopleByPage(int page, int maxNumber, int peopleType) {
        return peopleMapper.selectPeopleByPage(page, maxNumber, peopleType);
    }

    @Override
    public void save(People people) {
        peopleMapper.save(people);
    }

    @Override
    public void deleteById(int id) {
        peopleMapper.deleteById(id);
    }

    @Override
    public void update(People people) {
        peopleMapper.update(people);
    }

    public String savePeople(People people) {
        People sqlPeople = this.findPeopleByUsername(people.getUsername());
        people.setPassword(DigestUtils.md5DigestAsHex(people.getPassword().getBytes()));
        people.setIsUse(true);
        if (sqlPeople == null) {
            return baseDao.save(peopleMapper, people);
        } else if (sqlPeople.getIsUse()) {
            return StaticUtil.EXIST;
        } else {
            return baseDao.update(peopleMapper, people);
        }
    }

    public String updatePeople(People people) {
        return baseDao.update(peopleMapper, people);
    }
}
