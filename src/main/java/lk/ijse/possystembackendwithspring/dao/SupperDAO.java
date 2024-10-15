package lk.ijse.possystembackendwithspring.dao;

import java.util.Optional;

public interface SupperDAO<T> {
    Optional<T> findByTempId(String id);

}
