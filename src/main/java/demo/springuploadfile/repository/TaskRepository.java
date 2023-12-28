package demo.springuploadfile.repository;

import demo.springuploadfile.model.Task;
import demo.springuploadfile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
