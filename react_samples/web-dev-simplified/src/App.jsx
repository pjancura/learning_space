import { useEffect, useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import './App.css'
import { NewTodoForm } from './NewTodoForm';
import { TodoList } from './TodoList';

function App() {
  // component function format
  // hooks
  // ..then helper functions
  // ..then return statement

  // useState and useEffect are called hooks in React
  // they need to be declared at the top of your component function
  // hooks can't be rendered conditionally, be put in returns, or used in loops
  const [todos, setTodos] = useState(() => {
    const localValue = localStorage.getItem("ITEMS")
    if (localValue == null) return []

    return JSON.parse(localValue)
  });

  useEffect(() => {
    localStorage.setItem("ITEMS", JSON.stringify(todos))
  }, [todos])

  function addTodo(title) {
    setTodos(currentTodos => {
      return [...currentTodos, 
      {id: crypto.randomUUID(), title: title, completed: false },]});
  }
  
  console.log(todos);

  function toggleTodo(id, completed) {
    console.log(id, completed);
    setTodos(currentTodos => {
      console.log(currentTodos)
      return (currentTodos.map(todo => {
        if (todo.id ===id) {
          console.log("found");
          return {...todo, completed: completed}
        }
        return todo;
      }))
    })
  }

  function deleteTodo(id) {
    setTodos(currentTodos => {
      return currentTodos.filter(todo => todo.id !== id);
    })
  }


  



  return (
    // <>   is called a fragment...it is basically an empty tag
    <> 
      <NewTodoForm onSubmit={addTodo}/>
      <h1 className="header">Todo List</h1>
      <TodoList todos={todos} deleteTodo={deleteTodo} toggleTodo={toggleTodo}/>
    </>
  )
}

export default App
