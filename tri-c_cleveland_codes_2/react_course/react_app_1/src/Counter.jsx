import { useState } from "react";


export function Counter () {
    const [count, setCount] = useState(0);

    const increment = () => {
        // because updates are done in batches
        // inorder for this to function like count + 3
        // each setCount needs to update the count
        // including an updater function in setCount means that each setCount() will update count
        setCount(c => c + 1);
        setCount(c => c + 1);
        setCount(c => c + 1);
        setCount(c => c + 1);
    }

    const decrement = () => {
        setCount(c => c - 1);
        setCount(c => c - 1);
        setCount(c => c - 1);
    }

    const reset = () => {
        setCount(0);
    }

    return (
        <div className="counter-container">
            <p className="count-display">{count}</p>
            <button className="counter-button" onClick={decrement}>Decrement</button>
            <button className="counter-button" onClick={reset}>Reset</button>
            <button className="counter-button" onClick={increment}>Increment</button>
        </div>
    );
}