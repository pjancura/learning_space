import React, {useState} from "react"

function ToDo() {

    const [tasks, setTasks] = useState(["Eat", "Drink", "Be merry"]);
    const [newTask, setNewTask] = useState("");

    function handleInputChange(event) {
        setNewTask(event.target.value);
    }

    function addTask() {
        if (newTask.trim() !== "") {
            setTasks(t => [...t, newTask]);
            setNewTask("");
        }
    }

    function deleteTask(index) {
        const updatedTasks = tasks.filter((_, i) => i !== index);
        setTasks(updatedTasks);
    }

    function moveUp(index) {
        if (index>0) {
            const updatedTasks=[...tasks];
            [updatedTasks[index], updatedTasks[index-1]] = 
            [updatedTasks[index-1], updatedTasks[index]];
            setTasks(updatedTasks); 
        }
    }

    function moveDown(index) {
        if (index<tasks.length - 1) {
            const updatedTasks=[...tasks];
            [updatedTasks[index], updatedTasks[index+1]] = 
            [updatedTasks[index+1], updatedTasks[index]];
            setTasks(updatedTasks); 
        }
    }

    return(
        <div className="to-do-list">
            <h1>To Do List</h1>
            <div>
                <input type="text" value ={newTask} placeholder="task..." onChange={handleInputChange} />
                <button className="add-button" onClick={addTask}>Add</button>
                
                
                <ol>
                    {tasks.map((task, index) => 
                        <li key={index}>
                            <span className="text">{task}</span>
                            <button className="delete-button" onClick={() => deleteTask(index)} >Delete</button>
                            <button className="move-button" onClick={() => moveUp(index)} >Up</button>
                            <button className="move-button" onClick={() => moveDown(index)} >Down</button>
                        </li>
                )}
                </ol>
            </div>
        </div>
    );
}
export default ToDo