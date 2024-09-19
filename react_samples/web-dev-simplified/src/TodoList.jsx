import { TodoItem } from "./TodoItem";

export function TodoList({ todos, toggleTodo, deleteTodo }) {
    
    return (
        <ul className='list'> 
        {/* the next line is called "short circuiting" it allows the dev to have something render when a condition is met */}
        {todos.length === 0 && "No Todos"}   
        {todos.map(todo => {
            return (
                <TodoItem id={todo.id} title={todo.title} completed={todo.completed} key={todo.id} toggleTodo={toggleTodo} deleteTodo={deleteTodo}/>
            )
        })}
      </ul>
    )
}