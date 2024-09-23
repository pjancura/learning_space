import Header from './Components/Header'
import './App.css'
import Feed from './Components/Feed'


function App() {

  const places = [
    {
      id: crypto.randomUUID(),
      title: "Mount Fuji",
      datesVisited: "12 Jan, 2021 - 24 Jan, 2021",
      description: `Mount Fuji is the tallest mountain in Japan, standing at 3,776 meters (12,380 feet).
                    Mount Fuji is the single most popular tourist site in Japan, for both Japanese and
                    tourists.`,
      country: "JAPAN",
      googleMapsHyperlink: "https://www.google.com/maps/place/Mount+Fuji/@35.3606583,138.7067639,14z/data=!3m1!4b1!4m6!3m5!1s0x6019629a42fdc899:0xa6a1fcc916f3a4df!8m2!3d35.3606255!4d138.7273634!16zL20vMGNrczA?entry=ttu&g_ep=EgoyMDI0MDkxNi4wIKXMDSoASAFQAw%3D%3D",
      imageURL: "https://scrimba.com/links/travel-journal-japan-image-url",
    },
    {
      id: crypto.randomUUID(),
      title: "Sydney Opera House",
      datesVisited: "27 May, 2021 - 8 Jun, 2021",
      description: `The sydney Opera House is a multi-venue performing arts centre in Sydney.
                    Located on the banks of the Sydney Harbour, it is often
                    regarded as one of the 20th century's most famous and distinctive buildings`,
      country: "AUSTRALIA",
      googleMapsHyperlink: "https://www.google.com/maps/place/Sydney+Opera+House/@-33.8567799,151.2127218,17z/data=!3m1!4b1!4m6!3m5!1s0x6b12ae665e892fdd:0x3133f8d75a1ac251!8m2!3d-33.8567844!4d151.2152967!16zL20vMDZfbm0?entry=ttu&g_ep=EgoyMDI0MDkxNi4wIKXMDSoASAFQAw%3D%3D",
      imageURL: "https://scrimba.com/links/travel-journal-australia-image-url",
    },
    {
      id: crypto.randomUUID(),
      title: "Geirangerfjord",
      datesVisited: "01 Oct, 2021 - 18 Nov, 2021",
      description: `The Geiranger Fjord is a fjord in the Sunnmøre region of Møre og
                    Romsdal county, Norway. It is located entirely in the Stranda Municipality.`,
      country: "NORWAY",
      googleMapsHyperlink: "https://www.google.com/maps/place/Geirangerfjord/@62.1049113,6.9098374,11z/data=!3m1!4b1!4m6!3m5!1s0x46169d427b268c51:0xb8c99540dcc397fe!8m2!3d62.101506!4d7.0940817!16zL20vMDZ4eXFi?entry=ttu&g_ep=EgoyMDI0MDkxNi4wIKXMDSoASAFQAw%3D%3D",
      imageURL: "https://scrimba.com/links/travel-journal-norway-image-url",
    },
  ]

  return (
    <>
      <Header/>
      <Feed places={places}/>
    </>
  )
}

export default App
