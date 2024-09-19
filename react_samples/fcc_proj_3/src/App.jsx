import './App.css'
import CardDisplay from './Components/CardDisplay/CardDisplay'
import Hero from './Components/Hero/Hero'
import Navbar from './Components/Navbar/Navbar'


function App() {

  const cardDetails = [
    {
      id: crypto.randomUUID(),
      imageURL: "./src/assets/katie_zaferes.png",
      status: "SOLD OUT",
      reviewRating: 5.0,
      numberOfReviews: 6,
      country: "USA",
      title: "Life Lessons with Katie Zaferes",
      pricePerPerson: 136,
    },
    {
      id: crypto.randomUUID(),
      imageURL: "./src/assets/wedding-photography 1.png",
      status: "ONLINE",
      reviewRating: 5.0,
      numberOfReviews: 6,
      country: "USA",
      title: "Life Lessons with Katie Zaferes",
      pricePerPerson: 136,
    },
    {
      id: crypto.randomUUID(),
      imageURL: "./src/assets/mountain-bike 1.png",
      status: "",
      reviewRating: 5.0,
      numberOfReviews: 6,
      country: "USA",
      title: "Life Lessons with Katie Zaferes",
      pricePerPerson: 136,
    }
  ]

  return (
    <>
      <Navbar/>
      <Hero />
      <CardDisplay cardDetails={cardDetails}/>
    </>
  )
}

export default App
