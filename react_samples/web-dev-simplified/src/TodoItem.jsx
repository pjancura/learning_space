export function TodoItem({ completed, id, title, toggleTodo, deleteTodo }) {


    return ( 
        <li>
          <label>
            <input type="checkbox" checked={completed} id={id}
            onChange={e => {toggleTodo(e.target.id, e.target.checked)}}/>
            {title}
          </label>
          <button className='btn btn-danger' onClick={() => deleteTodo(id)} >Delete</button>
        </li> 
      )
}