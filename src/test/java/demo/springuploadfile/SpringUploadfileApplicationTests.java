package demo.springuploadfile;

import demo.springuploadfile.model.Task;
import demo.springuploadfile.model.User;
import demo.springuploadfile.repository.TaskRepository;
import demo.springuploadfile.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import java.util.*;

@SpringBootTest
@ContextConfiguration(classes = SpringUploadfileApplication.class)
class SpringUploadfileApplicationTests {

    public final UserRepository userRepository;

    public final TaskRepository taskRepository;

    @Autowired
    SpringUploadfileApplicationTests(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }


    @Test
    void contextLoads() {
        User user = User.builder()
                .username("sandeep")
                .build();

        User user1 = User.builder()
                .username("user1")
                .build();

        User user2 = User.builder()
                .username("user2")
                .build();

        User user3 = User.builder()
                .username("user3")
                .build();

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

    }

    @Test
    public void createTasks() {
        Task task = Task.builder()
                .title("task1")
                .description("task1")
                .build();

        Task task2 = Task.builder()
                .title("task2")
                .description("task2")
                .build();

        Task task3 = Task.builder()
                .title("task3")
                .description("task3")
                .build();


        taskRepository.save(task);
        taskRepository.save(task2);
        taskRepository.save(task3);

    }

    @Test
    void share(){

//        User user1 = userRepository.findById(1).get();
//        User user2 =userRepository.findById(2).get();
//        User user3 = userRepository.findById(3).get();

        Task task = taskRepository.findById(1).get();
        User user = userRepository.findById(1).get();
        System.out.println(task.getSharedUsers());
//        task.getSharedUsers().addAll(List.of(user1, user2, user3));
//        taskRepository.save(task);
    }

}
