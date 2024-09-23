import { useState } from 'react'

export default function ColorPicker () {
    const [color, setColor] = useState("#FFFFFF")

    function handleColorChange(e) {
        setColor(e.target.value)
    }

    return (
        <div className="color-picker-container">
            <h1>Color Picker</h1>

            <div className="color-display" style={{backgroundColor: color}}>
                <p>Seleted Color: {color}</p>
            </div>
            <label htmlFor="">Select a Color:</label>
            <input type="color" value={color} onChange={handleColorChange} />
        </div>
    );
}