// import { Header } from "./Header"
// import { Food } from "./Food"
// import { Footer } from "./Footer"
// import { Card } from "./Card"
// import { Button } from "./Button/Button"
// import { Student } from "./Student/Student"
// import { UserGreeting } from "./UserGreeting/UserGreeting"
// import { List } from "./List"
// import { Button } from "./Button";
// import { ProfilePicture } from "./ProfilePicture";
// import { MyComponentSecond } from "./MyComponentSecond"
import { Counter } from "./Counter"
import Car from "./Car"
import Foods from "./Foods"
import Car2 from "./Car2"



function App() {



  // const fruits = [{id: 1, name: "apple", calories: 95}, 
  //   {id: 2, name: "orange", calories: 45}, 
  //   {id: 3, name: "banana", calories: 105},
  //   {id: 4, name: "kiwi", calories: 37},
  //   {id: 5, name: "pineapple", calories: 200},
  //   ];

  //   const vegetables = [
  //     {id: 1, name: "potatoes", calories: 95}, 
  //     {id: 2, name: "celery", calories: 45}, 
  //     {id: 3, name: "carrots", calories: 105},
  //     {id: 4, name: "coprn", calories: 37},
  //     {id: 5, name: "broccoli", calories: 200},
  //     ];

  return (
    <>
      <Car2/>
      <Foods/>
      <Car/>
      {/* <MyComponentSecond/>  */}
      <Counter/>
      {/* <UserGreeting isLoggedIn={true} userName={"fingersmasher"}/>
      <UserGreeting isLoggedIn={false} userName={"fingersmasher"}/>
      <UserGreeting/> */}
      {/* {fruits.length > 0 ? <List items={fruits} category="Fruits"/> : null}
      {vegetables.length > 0 && <List items={vegetables} category="Vegetables"/>} */}
      {/* <Button/>
      <ProfilePicture/> */}
      {/* <Student name="Spongebob" age={30} isStudent={true}/>
      <Student name="Patrick" age={42} isStudent={false}/>
      <Student name="Squidward" age={50} isStudent={false}/>
      <Student name="Sandy" age={27} isStudent={true}/>
      <Student  name="Larry"/> */}
      {/* <Card/>
      <Button/>
      <Header/>
      <Food/>
      <Footer/> */}
    </>
  )
}

export default App
