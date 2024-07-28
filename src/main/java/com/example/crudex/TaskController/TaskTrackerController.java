package com.example.crudex.TaskController;
import com.example.crudex.API.APIResponse;
import com.example.crudex.modul.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

@RestController
@RequestMapping("/task/user/")
public class TaskTrackerController {
    ArrayList<Task> tasks = new ArrayList<Task>();

    @GetMapping("/get")
    public ArrayList<Task> getTaskTracker() {
        return tasks;
    }
    @PostMapping("/add")
    public APIResponse setTaskTracker(@RequestBody Task task) {
        tasks.add(task);
        return new APIResponse("Task Add");
    }
    @DeleteMapping("/delete/{index}")
    public APIResponse deleteTaskTracker(@PathVariable int index) {
        tasks.remove(index);
        return new APIResponse("Task Delete");
    }
    @PutMapping("/change/status/{status}/{index}")
    public APIResponse changeTaskStatus(@PathVariable String status,@PathVariable int index) {
        if (tasks.get(index).getStatus().equals("Done")) {
            return new APIResponse("Task Status is already Done");
        }else {
            tasks.get(index).setStatus(status);
            return new APIResponse("Task Status change to Done");
        }
    }

    @GetMapping("/search/{title}")
    public ArrayList<Task> searchTask(@PathVariable String title) {
        ArrayList<Task> allMatchTask = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                allMatchTask.add(task) ;
            }
        }
        return allMatchTask;
    }
    //update
    @GetMapping("/update/{id}")
    public APIResponse updateTask(@RequestBody Task task,@PathVariable int id){
        for (int i = 0; i <tasks.size() ; i++) {
            if (tasks.get(i).getId() == id) {
                tasks.set(i,task);
                return new APIResponse("Task Update");
            }
        }
        return new APIResponse("Not Task Update");
    }
}

