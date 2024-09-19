export function Navbar() {
    const navbarItems = ["React Facts", "Project 2", "Project 3"]

    const navItems = navbarItems.map(navbarItem => {
            return(
                <li key={crypto.randomUUID()}><a href="">{navbarItem}</a></li>
            ); 
        })


    return (
        <nav className="navbar">
            <ul>
                {navItems}
            </ul>
        </nav>
    );
}