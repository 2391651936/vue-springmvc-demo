package smart.application.appoint.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smart.application.appoint.dao.PeopleMapper;
import smart.application.appoint.models.People;
import smart.application.appoint.models.PeopleType;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PeopleService implements PeopleMapper {

    @Resource
    private PeopleMapper peopleMapper;

    @Override
    public People selectPeopleByUsername(String username) {
        return peopleMapper.selectPeopleByUsername(username);
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
}
