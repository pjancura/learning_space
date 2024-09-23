import { useState, useEffect } from "react";

export default function JSONPractice() {
    const [starWarsData, setStarWarsData] = useState({})
    const [count, setCount] = useState(0);

    // console.log("Component rendered")

    useEffect(() => {
        console.log(count);
        if (count > 0) {
            fetch(`https://swapi.dev/api/people/${count}`)
                .then(res => res.json())
                .then(data => setStarWarsData(data))
        }}, [count]   
    )

    function handleClick() {
        setCount(count + 1)
    }

    return (
        <div>
            <p>Count: <span>{count}</span></p>
            <button onClick={handleClick}>Get Next Character</button>
            <pre>{JSON.stringify(starWarsData, null, 2)}</pre>
        </div>
    );
}