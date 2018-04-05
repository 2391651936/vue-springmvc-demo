package smart.application.appoint.dao;

public interface BaseMapper<T> {
    void save(T t);

    void deleteById(int id);

    void update(T t);
}
