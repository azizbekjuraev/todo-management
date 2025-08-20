package net.javaguides.todo.service.impl;

import net.javaguides.todo.dto.TodoDto;
import net.javaguides.todo.entity.Todo;
import net.javaguides.todo.repository.TodoRepository;
import net.javaguides.todo.service.TodoService;

public class TodoServiceImpl implements TodoService {
    
    private TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        //convert todo dto into jpa entity
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescripton(todoDto.getDescription());
        todo.setComplete(todoDto.isCompleted());
       
        //todo jpa entity
        Todo savedTodo = todoRepository.save(todo);

        //convert saved todo jpa entity object into TodoDto object
        TodoDto saveTodoDto = new TodoDto();
        saveTodoDto.setId(savedTodo.getId());
        saveTodoDto.setTitle(savedTodo.getTitle());
        saveTodoDto.setDescription(savedTodo.getDescripton());
        saveTodoDto.setCompleted(savedTodo.getComplete());

        return saveTodoDto;
    }
}
