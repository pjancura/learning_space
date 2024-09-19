import "./Homepage.css"
import { Navbar } from "./Navbar";

export function Header() {
    return (
        <header>
            <a href="/"><img className="headerLogo" src="./src/assets/react.svg" alt="react logo" /></a>
            {/* <p>Composable, Declarative, Highly Maintained Library</p> */}
            <Navbar/>
        </header>
    );
}