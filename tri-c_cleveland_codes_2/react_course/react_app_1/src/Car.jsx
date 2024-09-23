import { useState } from "react"

export default function Car () {
    const [car, setCar] = useState({
        year: 2024,
        make: "Ford",
        model: "Mustang",
      })

      function handleYearChange(e) {
        setCar((c) => ({...c, year: e.target.value}))
      }

      function handleMakeChange(e) {
        setCar((c) => ({...c, make: e.target.value}))
      }

      function handleModelChange(e) {
        setCar((c) => ({...c, model: e.target.value}))
      }

      return (
        <div>
            <p>
                Your favorite car is: {car.year} {car.make} {car.model}
            </p>

            <input type="number" value={car.year} onChange={handleYearChange}></input>
            <input type="text" value={car.make} onChange={handleMakeChange}></input>
            <input type="text" value={car.model} onChange={handleModelChange}></input>
        </div>
      )
}