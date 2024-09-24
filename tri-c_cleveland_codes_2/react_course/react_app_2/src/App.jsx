import ColorPicker from './ColorPicker'
import ToDo from './ToDoComponents/ToDo.jsx'
import './App.css'
// import './ToDoComponents/index.css'
import MyComponent from './UseEffectHook/MyComponent.jsx'
import WidthAndHeight from './UseEffectHook/WidthAndHeight.jsx'
import DataFetching from './APIComponents/DataFetching.jsx'
// import Pagination from './Pagination/Pagination.jsx'
import Data from './Pagination/Data.jsx'
import "./Pagination/data.css"
import { useMemo, useState } from 'react'

let PageSize = 10;

function App() {


  return (
    <>
      {/* <ColorPicker/> */}
      {/* <ToDo/> */}
      <Data />
      <MyComponent/>
      <WidthAndHeight/>
      <DataFetching/>
    </>
  )
}

export default App
