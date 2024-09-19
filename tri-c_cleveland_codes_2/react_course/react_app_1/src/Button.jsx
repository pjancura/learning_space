export function Button() {
    let count = 0;
    
    const handleClick = (name) => {
        if (count < 3) {
            count++;
            console.log(`${name} you clicked me ${count} time/s`)
        } 
        else {
            console.log(`${name} stop clicking me!`);
        }
    }

    const handleClick3 = (e) => e.target.textContent = "OUCH! 🤬";

    const handleClick2 = (name) => console.log(`${name} stop clicking me`);
    return (
        // there is also a onDoubleClick event handler
        <button onClick={(e) => handleClick3(e)} >Click Me 😎</button>
    );
}